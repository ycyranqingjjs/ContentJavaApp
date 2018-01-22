package com.ycy.contentjavaapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ycy.common.base.CBaseFragment;
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

public class BaseFragment extends CBaseFragment {

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }
}
