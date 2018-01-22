package com.ycy.framework.widget.Banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.ycy.framework.widget.Banner.transformer.AccordionTransformer;
import com.ycy.framework.widget.Banner.transformer.BackgroundToForegroundTransformer;
import com.ycy.framework.widget.Banner.transformer.CubeInTransformer;
import com.ycy.framework.widget.Banner.transformer.CubeOutTransformer;
import com.ycy.framework.widget.Banner.transformer.DefaultTransformer;
import com.ycy.framework.widget.Banner.transformer.DepthPageTransformer;
import com.ycy.framework.widget.Banner.transformer.FlipHorizontalTransformer;
import com.ycy.framework.widget.Banner.transformer.FlipVerticalTransformer;
import com.ycy.framework.widget.Banner.transformer.ForegroundToBackgroundTransformer;
import com.ycy.framework.widget.Banner.transformer.RotateDownTransformer;
import com.ycy.framework.widget.Banner.transformer.RotateUpTransformer;
import com.ycy.framework.widget.Banner.transformer.ScaleInOutTransformer;
import com.ycy.framework.widget.Banner.transformer.StackTransformer;
import com.ycy.framework.widget.Banner.transformer.TabletTransformer;
import com.ycy.framework.widget.Banner.transformer.ZoomInTransformer;
import com.ycy.framework.widget.Banner.transformer.ZoomOutSlideTransformer;
import com.ycy.framework.widget.Banner.transformer.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
