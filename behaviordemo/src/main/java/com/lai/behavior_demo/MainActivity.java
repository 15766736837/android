package com.lai.behavior_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mBehaviorIv;
    int statusBarHeight1 = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getStateHeight();
    }

    private void initView() {
        mBehaviorIv = (ImageView) findViewById(R.id.behavior_iv);

        mBehaviorIv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        int moveX = (int) event.getRawX();
                        int moveY = (int) (event.getRawY() - statusBarHeight1);

                        mBehaviorIv.setX(moveX);
                        mBehaviorIv.setY(moveY);
                        break;
                }
                return true;
            }
        });
    }

    private void getStateHeight() {
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
    }
}














