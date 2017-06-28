package com.lai.explode_recycler_view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.TransitionManager;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.SetOnItemClickListener{

    private RelativeLayout mActivityMain;
    private RecyclerView mRlv;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
        mRlv = (RecyclerView) findViewById(R.id.rlv);

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 1000; i ++){
            datas.add(String.valueOf(i));
        }

        mMyAdapter = new MyAdapter(datas);
        mMyAdapter.setListener(this);
        mRlv.setLayoutManager(new GridLayoutManager(this, 4));
        mRlv.setAdapter(mMyAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(int Position) {
        //创建一个爆炸的动画
        Explode explode = new Explode();
        //延时时间
        explode.setDuration(1000);
        //监听ViewGroup,一旦变化就开始动画
        TransitionManager.beginDelayedTransition(mRlv, explode);
        //删除RecyclerView里面的数据,让其发生变化,从而启动动画
        mMyAdapter.removeDatas();
    }
}
