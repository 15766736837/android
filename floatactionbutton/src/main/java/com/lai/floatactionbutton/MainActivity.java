package com.lai.floatactionbutton;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBarTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_bar_layout);
        initView();

    }

    private void initView() {
        mToolBarTb = (Toolbar) findViewById(R.id.tool_bar_tb);
        mToolBarTb.inflateMenu(R.menu.main);

        mToolBarTb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                
                return false;
            }
        });
    }
}
