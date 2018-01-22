package com.ycy.common;

import com.tencent.bugly.crashreport.CrashReport;
import com.ycy.framework.FBaseApplication;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：CBaseAppliction
 * 创 建 日 期 ： 2017/12/23  21:02
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public abstract class CBaseAppliction extends FBaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化bugly
        CrashReport.initCrashReport(getApplicationContext(), "d2dcad7abd", false); //第三个参数为SDK调试模式开关在测试阶段建议设置成true，发布时设置为false

        //友盟

        //推送  ...

    }


}


