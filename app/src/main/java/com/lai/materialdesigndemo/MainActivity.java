package com.lai.materialdesigndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mCircle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_layout);
//        mCircle1 = (ImageView) findViewById(R.id.circle1);
//        mCircle1.setOnTouchListener(this);
    }

    /*@Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (Build.VERSION.SDK_INT >= 21)
                    mCircle1.setTranslationZ(1);
                break;
            case MotionEvent.ACTION_DOWN:
                if (Build.VERSION.SDK_INT >= 21)
                    mCircle1.setTranslationZ(0);
                break;
        }
        return true;
    }*/
}
