package com.ycy.framework;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.ycy.framework.crash.EnvChecker;
import com.ycy.framework.runtime.AppRuntime;
import com.ycy.framework.utils.logger.LogLevel;
import com.ycy.framework.utils.logger.Logger;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：FBaseApplication
 * 创 建 日 期 ： 2018/1/6  22:29
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public class FBaseApplication extends Application {
    public static volatile FBaseApplication INSTANCE;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        onPreRunTimeInit();
        AppRuntime.init(this);
    }
    protected void onPreRunTimeInit(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        // 在应用中安装MultiDex支持库  注意这个尽量往前放
        MultiDex.install(this);

//        if (AppRuntime.getProcessType() == ProcessType.PROCESS_TYPE_MAIN || AppRuntime.getProcessType() == ProcessType.PROCESS_TYPE_OTHER) {//其他进程也来一把
//            SystemBugFixUtils.fixOnApplicationCreate(this);
//        }

        //初始化Stetho调试工具
        Stetho.initializeWithDefaults(this);

        // Logger设置  （非必须）
        Logger
                .init("mytag")    //LOG TAG默认是PRETTYLOGGER
                .methodCount(3)                 // 决定打印多少行（每一行代表一个方法）默认：2
                .hideThreadInfo()               // 隐藏线程信息 默认：显示
                .logLevel(LogLevel.NONE)        // 是否显示Log 默认：LogLevel.FULL（全部显示）
                .methodOffset(2);                // 默认：0

        //oom和卡顿检测
        EnvChecker.installLeakCanary(this);
    }

}
