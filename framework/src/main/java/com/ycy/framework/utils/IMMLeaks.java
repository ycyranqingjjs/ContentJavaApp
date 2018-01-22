package com.ycy.framework.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

import com.ycy.framework.config.FrameworkConfig;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by f on 2017/5/12.
 */

class IMMLeaks {
    private static final String TAG = "leaks";

    private static class ReferenceCleaner
            implements MessageQueue.IdleHandler, View.OnAttachStateChangeListener,
            ViewTreeObserver.OnGlobalFocusChangeListener {

        private final InputMethodManager inputMethodManager;
        private final Field mHField;
        private final Field mServedViewField;
        private final Method finishInputLockedMethod;

        ReferenceCleaner(InputMethodManager inputMethodManager, Field mHField, Field mServedViewField,
                         Method finishInputLockedMethod) {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "ReferenceCleaner() called with: " + "inputMethodManager = [" + inputMethodManager + "], mHField = [" + mHField + "], mServedViewField = [" + mServedViewField + "], finishInputLockedMethod = [" + finishInputLockedMethod + "]");
            }

            this.inputMethodManager = inputMethodManager;
            this.mHField = mHField;
            this.mServedViewField = mServedViewField;
            this.finishInputLockedMethod = finishInputLockedMethod;
        }

        @Override
        public void onGlobalFocusChanged(View oldFocus, View newFocus) {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "onGlobalFocusChanged() called with: " + "oldFocus = [" + oldFocus + "], newFocus = [" + newFocus + "]");
            }

            if (newFocus == null) {
                return;
            }
            if (oldFocus != null) {
                oldFocus.removeOnAttachStateChangeListener(this);
            }
            Looper.myQueue().removeIdleHandler(this);
            newFocus.addOnAttachStateChangeListener(this);
        }

        @Override
        public void onViewAttachedToWindow(View v) {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "onViewAttachedToWindow() called with: " + "v = [" + v + "]");
            }

        }

        @Override
        public void onViewDetachedFromWindow(View v) {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "onViewDetachedFromWindow() called with: " + "v = [" + v + "]");
            }

            v.removeOnAttachStateChangeListener(this);
            Looper.myQueue().removeIdleHandler(this);
            Looper.myQueue().addIdleHandler(this);
        }

        @Override
        public boolean queueIdle() {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "queueIdle() called with: " + "");
            }

            clearInputMethodManagerLeak();
            return false;
        }

        private void clearInputMethodManagerLeak() {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "clearInputMethodManagerLeak() called with: " + "");
            }

            try {
                Object lock = mHField.get(inputMethodManager);
                // This is highly dependent on the InputMethodManager implementation.
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (lock) {
                    View servedView = (View) mServedViewField.get(inputMethodManager);
                    if (servedView != null) {

                        boolean servedViewAttached = servedView.getWindowVisibility() != View.GONE;

                        if (servedViewAttached) {
                            // The view held by the IMM was replaced without a global focus change. Let's make
                            // sure we get notified when that view detaches.

                            // Avoid double registration.
                            servedView.removeOnAttachStateChangeListener(this);
                            servedView.addOnAttachStateChangeListener(this);
                        } else {
                            // servedView is not attached. InputMethodManager is being stupid!
                            Activity activity = extractActivity(servedView.getContext());
                            if (activity == null || activity.getWindow() == null) {
                                // Unlikely case. Let's finish the input anyways.
                                finishInputLockedMethod.invoke(inputMethodManager);
                            } else {
                                View decorView = activity.getWindow().peekDecorView();
                                boolean windowAttached = decorView.getWindowVisibility() != View.GONE;
                                if (!windowAttached) {
                                    finishInputLockedMethod.invoke(inputMethodManager);
                                } else {
                                    decorView.requestFocusFromTouch();
                                }
                            }
                        }
                    }
                }
            } catch (Exception unexpected) {
                if (FrameworkConfig.DEBUG) {
                    Log.e(TAG, "clearInputMethodManagerLeak: ERROR", unexpected);
                }
            }
        }

        private Activity extractActivity(Context context) {
            if (FrameworkConfig.DEBUG) {
                Log.d(TAG, "extractActivity() called with: " + "context = [" + context + "]");
            }

            while (true) {
                if (context instanceof Application) {
                    return null;
                } else if (context instanceof Activity) {
                    return (Activity) context;
                } else if (context instanceof ContextWrapper) {
                    Context baseContext = ((ContextWrapper) context).getBaseContext();
                    // Prevent Stack Overflow.
                    if (baseContext == context) {
                        return null;
                    }
                    context = baseContext;
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Fix for https://code.google.com/p/android/issues/detail?id=171190 .
     * <p>
     * When a view that has focus gets detached, we wait for the main thread to be idle and then
     * check if the InputMethodManager is leaking a view. If yes, we tell it that the decor view got
     * focus, which is what happens if you press home and come back from recent apps. This replaces
     * the reference to the detached view with a reference to the decor view.
     * <p>
     * Should be called from {@link Activity#onCreate(Bundle)} )}.
     */
    static void fixFocusedViewLeak(Application application) {
        if (FrameworkConfig.DEBUG) {
            Log.d(TAG, "fixFocusedViewLeak() called with: " + "application = [" + application + "]");
        }


        // Don't know about other versions yet.
//        if (SDK_INT < KITKAT || SDK_INT > M) {
//            if (DEBUG) {
//                Log.w(TAG, "fixFocusedViewLeak: IGNORED due to unknown android version.");
//            }
//            return;
//        }

        final InputMethodManager inputMethodManager =
                (InputMethodManager) application.getSystemService(INPUT_METHOD_SERVICE);

        final Field mServedViewField;
        final Field mHField;
        final Method finishInputLockedMethod;
        final Method focusInMethod;
        try {
            mServedViewField = InputMethodManager.class.getDeclaredField("mServedView");
            mServedViewField.setAccessible(true);
            mHField = InputMethodManager.class.getDeclaredField("mH");
            mHField.setAccessible(true);
            finishInputLockedMethod = InputMethodManager.class.getDeclaredMethod("finishInputLocked");
            finishInputLockedMethod.setAccessible(true);
            focusInMethod = InputMethodManager.class.getDeclaredMethod("focusIn", View.class);
            focusInMethod.setAccessible(true);
        } catch (Exception unexpected) {
            if (FrameworkConfig.DEBUG) {
                Log.e(TAG, "fixFocusedViewLeak: ERROR", unexpected);
            }
            return;
        }


        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                if (FrameworkConfig.DEBUG) {
                    Log.d(TAG, "onActivityResumed() called with: " + "activity = [" + activity + "]");
                }

                ReferenceCleaner cleaner =
                        new ReferenceCleaner(inputMethodManager, mHField, mServedViewField,
                                finishInputLockedMethod);
                View rootView = activity.getWindow().getDecorView().getRootView();
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                viewTreeObserver.addOnGlobalFocusChangeListener(cleaner);

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                if (FrameworkConfig.DEBUG) {
                    LogUtil.i(TAG, "onActivityDestroyed() " + activity);
                }
                fixInputMethodManagerLeak(activity);

            }

        });
    }

    static void fixInputMethodManagerLeak(Context destContext) {
        if (destContext == null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) destContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }

        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        Field f = null;
        Object obj_get = null;
        for (int i = 0; i < arr.length; i++) {
            String param = arr[i];
            try {
                f = imm.getClass().getDeclaredField(param);
                if (f.isAccessible() == false) {
                    f.setAccessible(true);
                } // author: sodino mail:sodino@qq.com
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    View v_get = (View) obj_get;
                    if (v_get.getContext() == destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                        break;
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}