package com.ycy.contentjavaapp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ycy.common.base.CBaseFragment;
import com.ycy.common.di.component.AppComponent;
import com.ycy.common.integration.cache.Cache;
import com.ycy.common.mvp.IPresenter;

import javax.inject.Inject;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：CBaseActivity
 * 创 建 日 期 ： 2017/12/23  21:01
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public class BaseFragment<P extends IPresenter> extends CBaseFragment {

    @Inject
    @NonNull
    @Override
    public synchronized Cache<String, Object> provideCache() {
        return super.provideCache();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    @Override
    public boolean useEventBus() {
        return true;
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
