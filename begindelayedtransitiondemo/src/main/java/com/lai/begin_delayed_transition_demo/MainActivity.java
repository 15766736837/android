package com.lai.begin_delayed_transition_demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private LinearLayout mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    public void click(View view) {
        int visibility = mTv.getVisibility();

        if (Build.VERSION.SDK_INT >= 21) {
            //开始监视ViewGroup,对象一旦发生变化,就会执行动画
            TransitionManager.beginDelayedTransition(mContent, new Slide(Gravity.RIGHT));
        }

        mTv.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
    }
}
