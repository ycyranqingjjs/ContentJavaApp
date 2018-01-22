package com.ycy.framework.utils;

import android.app.Application;

/**
 * Created by f on 2017/5/12.
 */

public class SystemBugFixUtils {
    public static void fixOnApplicationCreate(Application application) {
        fixLeak_InputMethodManager_mCurRootView(application);
    }

    private static void fixLeak_InputMethodManager_mCurRootView(Application application) {
        IMMLeaks.fixFocusedViewLeak(application);
    }
}
