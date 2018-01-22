package com.ycy.contentjavaapp.base;

import android.os.Bundle;

import com.ycy.common.base.CBaseActivity;
import com.ycy.common.di.component.AppComponent;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：CBaseActivity
 * 创 建 日 期 ： 2017/12/23  21:01
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public class BaseActivity extends CBaseActivity {

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId(Bundle savedInstanceState) {
        return 0;
    }
}
