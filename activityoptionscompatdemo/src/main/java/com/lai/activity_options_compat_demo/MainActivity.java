package com.lai.activity_options_compat_demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.in, R.anim.out);
    }

    public void makeSceneTransitionAnimation(View view) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                Pair.create(findViewById(R.id.img1), "noe"),
                Pair.create(findViewById(R.id.img2), "two"));
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }

    //使用自定义动画的效果
    public void makeCustomAnimation(View view) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.in, R.anim.out);
        Intent intent = new Intent(this, MyActivity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }

    //使用缩放动画缩放
    public void makeScaleUpAnimation(View view) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        Intent intent = new Intent(this, MyActivity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }

    //位于图片左上角的一个偏移量开始缩放
    public void makeThumbnailScaleUpAnimation(View view) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a4);
        ActivityOptionsCompat compat =
                ActivityOptionsCompat.makeThumbnailScaleUpAnimation(view, bitmap, -500, 500);
        Intent intent = new Intent(this, MyActivity.class);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }


}
