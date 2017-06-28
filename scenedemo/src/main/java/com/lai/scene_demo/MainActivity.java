package com.lai.scene_demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mActivityMain;
    private Scene mScene1;
    private Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            //创建两个场景
            mScene1 = Scene.getSceneForLayout(mActivityMain, R.layout.scene1_layout, this);
            mScene2 = Scene.getSceneForLayout(mActivityMain, R.layout.scene2_layout, this);

            //一开始Activity就切换到场景1,为了到场景二后可以切换回场景二
            TransitionManager.go(mScene1, new ChangeBounds());
        }
    }

    //切换到场景二
    public void click(View view) {
        if (Build.VERSION.SDK_INT >= 21 && mScene1 != null) {
            TransitionManager.go(mScene2, new ChangeBounds());
        }
    }

    //切换到场景1
    public void scene2(View view) {
        if (Build.VERSION.SDK_INT >= 21 && mScene1 != null) {
            TransitionManager.go(mScene1, new ChangeBounds());
        }
    }
}
