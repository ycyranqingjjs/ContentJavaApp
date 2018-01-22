package com.ycy.contentjavaapp;

import android.os.Bundle;
import android.widget.TextView;

import com.ycy.common.base.CBaseActivity;
import com.ycy.common.di.component.AppComponent;

import butterknife.BindView;

public class MainActivity extends CBaseActivity {

//    private TextView mTv;

    @BindView(R.id.sample_text)
    TextView mTextView;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView mTv;


    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTv = (TextView) findViewById(R.id.sample_text);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        mTextView.setText("fsjofijasoi");
//        mTv.setText(stringFromJNI());
    }

    @Override
    public void initToolBar() {
    }


    @Override
    public int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
