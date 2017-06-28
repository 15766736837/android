package com.lai.ripple_demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lai on 2017/6/27.
 */

public class RippleActivity extends AppCompatActivity{
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripper_activity_layout);
    }

    public void click(View view) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                findViewById(R.id.circle1), "circle");
        Intent intent = new Intent(this, CircleActivity2.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }
}
