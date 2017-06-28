package com.lai.ripple_demo;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFl;
    private RelativeLayout mActivityMain;
    private int mWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取屏幕宽度
        WindowManager wm = this.getWindowManager();
        mWidth = wm.getDefaultDisplay().getWidth();

        initView();
    }

    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void click(View view) {
        Animator anim = ViewAnimationUtils.createCircularReveal(
                mFl, (int)(mWidth / 2), (int)(mFl.getMeasuredHeight() / 2),
                0, mWidth);
        mFl.setBackgroundColor(Color.RED);
        anim.setDuration(2000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }
}
