package com.ycy.common.widget.autoscrollviewpager.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;


/**
 * 创建时间:15/6/19 上午8:41
 * 描述:
 */
public class StackPageTransformer extends BGAPageTransformer {

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);
    }

}