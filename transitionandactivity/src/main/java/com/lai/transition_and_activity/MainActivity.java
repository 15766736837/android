package com.lai.transition_and_activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //想要使用transition动画需要配置
        Slide explode = new Slide(Gravity.RIGHT);
        getWindow().setExitTransition(explode);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_and_transition);
    }

    public void explose(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        if (Build.VERSION.SDK_INT >= 21)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
