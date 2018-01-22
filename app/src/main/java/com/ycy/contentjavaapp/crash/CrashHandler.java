package com.ycy.contentjavaapp.crash;

import android.content.Context;
import android.util.Log;

import com.ycy.contentjavaapp.config.AppConfig;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static CrashHandler INSTANCE;
    private final Context mContext;

    private CrashHandler(Context c) {
        mContext = c;
    }

    public static CrashHandler getInstance(Context c) {
        if (INSTANCE == null) {
            INSTANCE = new CrashHandler(c);
        }
        return INSTANCE;
    }

    public void init() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang
     * .Thread, java.lang.Throwable)
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (DEBUG) {
            if (DEBUG) {
                Log.e(TAG, "Application Crashed!", ex);
            }
        }
        if (DEBUG) {
            String exception = throwable2String(ex);
            CrashActivity.start(mContext, exception);
        } else {//正式版本用友盟？
            //		try {
//
//			saveToSDCard(ex);
//			ActivityPageManager.getInstance().finishAllActivity();
//			MobclickAgent.onKillProcess(BottleApplication.getInstance());
            // 联网发送
//			MobclickAgent.reportError(BottleApplication.getInstance(), str);//发给友盟统计


//			Intent intent = new Intent(BottleApplication.getInstance(), WelcomeActivity.class);
//			PendingIntent restartIntent = PendingIntent.getActivity(BottleApplication.getInstance(), 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
//			//退出程序
//			AlarmManager mgr = (AlarmManager) BottleApplication.getInstance().getSystemService(Context.ALARM_SERVICE);
//			mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000,
//					restartIntent); // 1秒钟后重启应用
//
//			System.exit(0);
//		} catch (Exception localException) {
//
//		}
        }

        System.exit(1);
    }

    /**
     * get crash info
     */
    private String throwable2String(Throwable ex) {
        Writer info = new StringWriter();
        PrintWriter printWriter = new PrintWriter(info);
        ex.printStackTrace(printWriter);

        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        //版本号和build号再说吧。
        String result = info.toString();
        printWriter.close();
        return result;
    }


}