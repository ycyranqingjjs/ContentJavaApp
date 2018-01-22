package com.ycy.framework.crash;

import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;
import com.ycy.framework.config.FrameworkConfig;
import com.ycy.framework.runtime.AppRuntime;
import com.ycy.framework.runtime.ProcessType;

/**
 * Created by yaocheng on 2017/5/6.
 */

public class EnvChecker {
    public static void installLeakCanary(Application application) {
        try {
            if (!LeakCanary.isInAnalyzerProcess(application)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                LeakCanary.install(application);
            }
            if(FrameworkConfig.DEBUG){
//                com.ztgame.bigbang.lib.framework.utils.LogUtil.i("yaocheng", "install leak succ");
            }

        } catch (Exception e) {
            if(FrameworkConfig.DEBUG){
//                com.ztgame.bigbang.lib.framework.utils.LogUtil.e("yaocheng", "install leak failed", e);
            }
        }

    }

    public static void installBlockCanary(Application application) {
        try {
            if (AppRuntime.getProcessType() == ProcessType.PROCESS_TYPE_MAIN) {//先只在这个进程下检测吧。
                BlockCanary.install(application, new AppBlockCanaryContext()).start();
                if(FrameworkConfig.DEBUG){
//                    com.ztgame.bigbang.lib.framework.utils.LogUtil.i("yaocheng", "install block succ");
                }
            }
        } catch (Exception e) {
            if(FrameworkConfig.DEBUG){
//                com.ztgame.bigbang.lib.framework.utils.LogUtil.e("yaocheng", "install block failed", e);
            }
        }

    }
}
