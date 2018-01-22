package com.ycy.framework.utils;

import android.text.TextUtils;
import android.util.Log;

import com.ycy.framework.config.FrameworkConfig;
import com.ycy.framework.runtime.AppRuntime;


/**
 * Created by yaocheng on 2017/4/28.
 * 这个类不够了随时加，有一些log的api没写。
 */

public class LogUtil {
    private static final boolean DEBUG = FrameworkConfig.DEBUG;

    public static void i(String tag, String text) {
        if (DEBUG) {
            Log.i(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text));
        }
    }

    public static void d(String tag, String text) {
        if (DEBUG) {
            Log.d(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text));
        }
    }
//
//    public static void d(String tag, String text, Throwable tr) {
//        if (DEBUG) {
//            Log.d(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text), tr);
//        }
//    }

    public static void v(String tag, String text) {
        if (DEBUG) {
            Log.v(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text));
        }
    }

    //    public static void v(String tag, String text, Throwable tr) {
//        if (DEBUG) {
//            Log.v(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text), tr);
//        }
//    }
    public static void w(String tag, String text) {
        if (DEBUG) {
            Log.w(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text));
        }
    }

    public static void e(String tag, String text, Throwable e) {
        if (DEBUG) {
            Log.w(tag, getFileLineMethod() + ":" + (TextUtils.isEmpty(text) ? "" : text), e);
        }
    }

    private static String getFileLineMethod() {
        if (DEBUG) {
            StackTraceElement element = new Exception().getStackTrace()[2];
//            if(View.isInEditMode()){
//
//            }
            ;
            String processName = AppRuntime.sSubProcessName;
            if (processName != null) {
                int index = processName.indexOf(":");
                if (index > -1) {
                    processName = processName.substring(Math.min(index + 1, processName.length()));
                }
            }

            if (TextUtils.isEmpty(processName)) {
                processName = "main";
            }
            StringBuffer buffer = new StringBuffer("[process:")
                    .append(processName)
                    .append("|thread:")
                    .append(Thread.currentThread().getName())
                    .append("|")
                    .append(element.getFileName())
                    .append("|")
                    .append(element.getMethodName())
                    .append("|")
                    .append(element.getLineNumber())
                    .append("]");
            return buffer.toString();
        }
        return null;
    }
}
