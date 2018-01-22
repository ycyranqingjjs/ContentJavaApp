package com.ycy.contentjavaapp.config;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

import com.facebook.stetho.common.LogUtil;
import com.ycy.common.BuildConfig;
import com.ycy.framework.FBaseApplication;
import com.ycy.framework.utils.Utils;


/**
 * Created by yaocheng on 2017/5/3.
 */

public class AppConfig {
    public static final boolean DEBUG = BuildConfig.DEBUG;

    public static final int SIGNAL_LOGOUT = 0;
    public static final int SEND_SYNAMIC_SUCC = 1;
    public static final int ACCEPT_FRIEND_SUCC = 2;
    public static final int UPDATE_OTHER_INFO_SUCC = 3;//目前没用，只是设置备注啥的时候用一下
    public static final int PUSH_FRIENDR_EQUEST = 4;
    public static final int PUSH_FRIENDR_EQUEST_DEL = 5;
//    public static final int PUSH_FANS_EQUEST = 6;
//    public static final int PUSH_FANS_EQUEST_DEL = 7;
    public static final int UPDATE_USERINFO_SUCC = 8;
    public static final int DEL_SYNAMIC_SUCC = 9;
    public static final int UPDATE_FRIEND_STATUS_SUCC = 10;
    public static final int ADD_MUSIC_SUCC = 11;
    public static final int REMOVE_MUSIC_SUCC = 12;
    public static final int SEND_FOLLOW_SUCC = 13;
    public static final int EXCHANGE_CASH_SUCC = 14;
    public static final int EXCHANGE_CARD_CHANGE_SUCC = 15;

    private static String sPhoneId = null;
    private static String sPackageNameFromSystem = null;
    private static String sSigHash = null;

    public static String getPhoneId() {
        if (sPhoneId == null) {
            sPhoneId = Settings.Secure.getString(FBaseApplication.INSTANCE.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        if (sPhoneId != null) {
            return sPhoneId;
        }
        return "";
    }

    public static String getPackageName() {
        if (sPackageNameFromSystem == null) {
            loadPackageInfo();
        }
        if (sPackageNameFromSystem != null) {
            return sPackageNameFromSystem;
        }
        return "";
    }

    public static String getSign() {
        if (sSigHash == null) {
            loadPackageInfo();
        }
        if (sSigHash != null) {
            return sSigHash;
        }
        return "";
    }

    private static void loadPackageInfo() {
        PackageManager pm = FBaseApplication.INSTANCE.getPackageManager();
        sPackageNameFromSystem = FBaseApplication.INSTANCE.getPackageName();

        try {
            PackageInfo pi = pm.getPackageInfo(sPackageNameFromSystem, PackageManager.GET_SIGNATURES);
            if (pi != null) {
                if (pi.signatures != null && pi.signatures.length > 0) {
                    sSigHash = Utils.getMD5(pi.signatures[0].toByteArray());
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (AppConfig.DEBUG) {
                LogUtil.e("yaocheng", "[cached]", e);
            }

        }
    }
}
