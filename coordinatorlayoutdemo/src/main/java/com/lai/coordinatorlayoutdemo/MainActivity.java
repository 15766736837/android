package com.lai.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mCtl;
    private Toolbar mToolBar;
    private AppBarLayout mAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mCtl = (CollapsingToolbarLayout) findViewById(R.id.ctl);
//        mCtl.setCollapsedTitleTextColor(Color.RED);
//        mCtl.setExpandedTitleColor(Color.RED);
        //        mCtl.setTitle("");

        mToolBar = (Toolbar) findViewById(R.id.tool_bar);
    }
}
