package com.lai.scene_demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Lai on 2017/6/27.
 */

public class Scene2Activity extends AppCompatActivity {
    RelativeLayout content;
    Scene one;
    Scene two;
    Scene three;
    Scene four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testscene);

        //确定舞台
        content = (RelativeLayout) findViewById(R.id.content);

        if (Build.VERSION.SDK_INT >= 19) {
            one = Scene.getSceneForLayout(content, R.layout.one, this);
            two = Scene.getSceneForLayout(content, R.layout.two, this);
            three = Scene.getSceneForLayout(content, R.layout.three, this);
            four = Scene.getSceneForLayout(content, R.layout.four, this);
        }
    }


    public void goTo1(View view) {
        goScene(one);
    }

    public void goTo2(View view) {
        goScene(two);
    }

    public void goTo3(View view) {
        goScene(three);
    }

    public void goTo4(View view) {
        goScene(four);
    }

    //跳转到下一个场景
    private void goScene(Scene s) {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionManager.go(s, new ChangeBounds());
        }
    }
}
