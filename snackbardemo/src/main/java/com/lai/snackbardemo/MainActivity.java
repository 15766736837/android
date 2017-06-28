package com.lai.snackbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemClock.sleep(300);

        initView();
    }

    private void initView() {
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
    }

    public void click(View view) {

        Snackbar snackbar = Snackbar.make(mActivityMain, "我是消息...", Snackbar.LENGTH_LONG);
        snackbar.setAction("Action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "我被点击了...", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();

        /**
         * 参数一:需要一个SnackBar
         * 参数二:SnackBar消息的颜色
         * 参数三:SnackBar的背景颜色
         */
        setSnackbarColor(snackbar, Color.WHITE, Color.YELLOW);

        //自定义的一个布局
     /*   View inflate = View.inflate(this, R.layout.snack_bar_layout, null);
        //创建一个短显示的Snackbar
        Snackbar snackbar = Snackbar.make(mActivityMain, "我是消息...", Snackbar.LENGTH_SHORT);

        //给SnackBar设置一个点击事件
        snackbar.setAction("这是一个Activity", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "我是SnackBar我被点击了...", Toast.LENGTH_SHORT).show();
            }
        });

        //修改SnackBar的背景颜色和消息颜色
        setSnackbarColor(snackbar, Color.BLACK, Color.YELLOW);
        //把自定义的布局设置到SnackBar中
        //SnackbarAddView(snackbar, R.layout.snack_bar_layout, 0);

        //显示
        snackbar.show();*/
    }

    public void setSnackbarColor(Snackbar s, int msgColor, int backgroundColor) {
        View view = s.getView();
        if (view != null) {
            view.setBackgroundColor(backgroundColor);
            TextView tv = (TextView) view.findViewById(R.id.snackbar_text);
            tv.setTextColor(msgColor);

            tv.setGravity(Gravity.CENTER);

//            Drawable d = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
//            d.setBounds(0, 0, d.getMinimumWidth(), d.getMinimumHeight());
//            tv.setCompoundDrawables(d, null, null, null);
        }
    }

    public void SnackbarAddView(Snackbar snackbar, int layoutId, int index) {
        //获取snackbar的View(其实就是SnackbarLayout)
        View snackbarview = snackbar.getView();
        //将获取的View转换成SnackbarLayout
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarview;
        //加载布局文件新建View
        View add_view = LayoutInflater.from(snackbarview.getContext()).inflate(layoutId, null);
        //设置新建布局参数
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置新建布局在Snackbar内垂直居中显示
        p.gravity = Gravity.CENTER_VERTICAL;
        //将新建布局添加进snackbarLayout相应位置
        snackbarLayout.addView(add_view, index, p);
    }
}
