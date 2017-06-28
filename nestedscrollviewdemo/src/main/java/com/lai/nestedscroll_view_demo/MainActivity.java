package com.lai.nestedscroll_view_demo;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mNestedScrollLv;
    private NestedScrollView mActivityMain;
    private List<String> mLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initView();
    }

    private void initView() {
//        mNestedScrollLv = (ListView) findViewById(R.id.nested_scroll_lv);
//        for (int i = 0; i < 50; i ++){
//            mLists.add("我是第"+i+"个...");
//        }
//
//        MyAdapter myAdapter = new MyAdapter();
//        mNestedScrollLv.setAdapter(myAdapter);
    }




    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mLists.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = View.inflate(MainActivity.this, android.R.layout.simple_list_item_1, null);
            TextView tv = (TextView) view.findViewById(android.R.id.text1);

            tv.setText(mLists.get(position));

            return view;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
