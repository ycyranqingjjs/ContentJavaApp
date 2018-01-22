package com.ycy.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：CBaseActivity
 * 创 建 日 期 ： 2017/12/23  21:01
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public abstract class FBaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
