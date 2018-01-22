package com.ycy.contentjavaapp.crash;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ycy.common.BuildConfig;
import com.ycy.contentjavaapp.config.AppConfig;

import static android.util.Log.e;

/**
 * Created by f on 2017/4/26.
 */

public class CrashActivity extends Activity {
    private static final String TAG = "CrashActivity";
    private static final boolean DEBUG = AppConfig.DEBUG;
    private String crashMessage;

    public static void start(Context context, String exceptionString) {
//        if (AppConfig.DEBUG) {
//            LogUtil.i("yaocheng", "");
//        }

        try {
            Intent intent = new Intent(context, CrashActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("crash", exceptionString);
            context.startActivity(intent);
//            if (AppConfig.DEBUG) {
//                LogUtil.i("yaocheng", "");
//            }
        } catch (Exception e) {
            if (DEBUG) {
                e(TAG, "ERROR_SOCKET_NOT_CONNECT", e);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        crashMessage = getIntent().getStringExtra("crash");
        if (DEBUG) {
            Log.e(TAG, "onCreate() called with: exception = [" + crashMessage + "]");
        } else {
            //如果是正式版本,不要被外部调用起来
            finish();
        }

//        createUploadResultDlg(BuildConfig.VERSION_NAME + "_" + BuildConfig.Build + "\n" + crashMessage).show();
        createUploadResultDlg(BuildConfig.VERSION_NAME + "_" +  "\n" + crashMessage).show();


    }

    private void onExit() {
        finish();
        System.exit(0);
    }

    private Dialog createUploadResultDlg(String crashMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("崩溃了，请务必拿给开发人员看下，多谢。");
        builder.setMessage(crashMessage);

        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onExit();
            }
        });
        builder.setPositiveButton("重启", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
                    CrashActivity.this.startActivity(intent);
                } catch (Exception e) {
                    if (DEBUG) {
                        e(TAG, "ERROR_SOCKET_NOT_CONNECT", e);
                    }
                }
                onExit();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        return alertDialog;
    }
}
