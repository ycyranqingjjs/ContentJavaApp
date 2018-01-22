package com.ycy.framework.runtime;

import android.support.annotation.IntDef;
import android.text.TextUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yaocheng on 2017/5/2.
 */

public class ProcessType {
    @IntDef({PROCESS_TYPE_MAIN, PROCESS_TYPE_CORE, PROCESS_TYPE_CRASH, PROCESS_TYPE_OTHER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Process {

    }

    //通常默认进程，ui进程我们认为是main
    public static final int PROCESS_TYPE_MAIN = 0;
    //core进程，一般是push之类的吧。
    public static final int PROCESS_TYPE_CORE = 1;
    //崩溃管理进程，这个进程通常是不做崩溃保护的。
    public static final int PROCESS_TYPE_CRASH = 2;
    //其他进程，现在还没定义，这个留着扩展用。
    public static final int PROCESS_TYPE_OTHER = 3;

    //暂时先用subname来判断一下。
    public static
    @Process
    int getProcessTypeByName(String subName) {
        if (TextUtils.isEmpty(subName)) {
            return PROCESS_TYPE_MAIN;
        } else if (":core".equals(subName)) {
            return PROCESS_TYPE_CORE;
        } else if (":crash".equals(subName)) {
            return PROCESS_TYPE_CRASH;
        }
        return PROCESS_TYPE_OTHER;
    }

    public static String getProcessNameByType(@Process int type) {
        switch (type) {
            case PROCESS_TYPE_MAIN:
                return "";
            case PROCESS_TYPE_CORE:
                return ":core";
            case PROCESS_TYPE_CRASH:
                return ":crash";
            default:
                throw new RuntimeException("unknow type " + type);
        }
    }
}
