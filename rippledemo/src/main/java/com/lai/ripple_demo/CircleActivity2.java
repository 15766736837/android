package com.lai.ripple_demo;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.ViewAnimationUtils;
import android.view.Window;

/**
 * Created by Lai on 2017/6/27.
 */

public class CircleActivity2 extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ChangeBounds changeBounds = new ChangeBounds();
        //进场动画结束后,再执行水波纹动画
        changeBounds.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                //水波纹动画
                show();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });


        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setSharedElementEnterTransition(changeBounds);
        setContentView(R.layout.circle_activit_layout2);
    }

    public void show(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //位置
        int width = toolbar.getMeasuredWidth() / 2;
        int height = toolbar.getMeasuredHeight() / 2;

        int max = Math.max(width, height);

        Animator anim = ViewAnimationUtils.createCircularReveal(toolbar, width, height, 0, max);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        anim.setDuration(1000);
        anim.start();
    }
}
