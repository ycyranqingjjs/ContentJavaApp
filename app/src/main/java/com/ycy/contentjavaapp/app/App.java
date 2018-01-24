package com.ycy.contentjavaapp.app;


import com.ycy.common.base.CBaseApplication;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：App
 * 创 建 日 期 ： 2017/12/9  21:16
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public class App extends CBaseApplication {

    public static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        init();

    }

    private void init() {

    }

    public static App getInstance()
    {

        return mInstance;
    }
}
