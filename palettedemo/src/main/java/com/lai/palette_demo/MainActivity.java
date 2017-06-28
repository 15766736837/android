package com.lai.palette_demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mVp;
    private List<ImageView> mImageViews = new ArrayList<>();
    private HandlerThread mHandlerThread;
    private Handler mHandler;
    private Handler mMainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //子线程
        mHandlerThread = new HandlerThread("worker");
        mHandlerThread.start();

        mHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                int arg1 = msg.arg1;
                getPhotoColor(arg1);
            }
        };

        //主线程
        mMainHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                setColor(msg.arg1);
            }
        };

        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        MyPageAdapter adapter = new MyPageAdapter();

        mVp.addOnPageChangeListener(this);

        ImageView imageView1 = createImageView(R.mipmap.a);
        ImageView imageView2 = createImageView(R.mipmap.b);
        ImageView imageView3 = createImageView(R.mipmap.c);

        mImageViews.add(imageView1);
        mImageViews.add(imageView2);
        mImageViews.add(imageView3);

        mVp.setAdapter(adapter);
    }

    //获取ViewPage每一个Item的颜色
    private void getPhotoColor(int index) {
        Bitmap bitmap = null;
        switch (index) {
            case 0:
                bitmap = (Bitmap) getBitmap(R.mipmap.a);
                break;
            case 1:
                bitmap = (Bitmap) getBitmap(R.mipmap.b);
                break;
            case 2:
                bitmap = (Bitmap) getBitmap(R.mipmap.c);
                break;
        }

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int color = 0;
                if (palette.getDarkMutedSwatch() != null) {
                    color = palette.getDarkMutedSwatch().getRgb();
                } else if (palette.getLightMutedSwatch() != null) {
                    color = palette.getLightMutedSwatch().getRgb();
                }
                mMainHandler.obtainMessage(0, color, 0).sendToTarget();
            }
        });
    }

    //获取item图片的Bitmap
    public Bitmap getBitmap(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        return bitmap;
    }

    public void setColor(int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            //状态栏颜色
            window.setStatusBarColor(color);
            //导航栏颜色
            window.setNavigationBarColor(color);
        }
    }

    //创建ImageView
    public ImageView createImageView(int resId) {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(resId);
        return imageView;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mHandler.obtainMessage(1, position, 0).sendToTarget();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //注销HandlerThread
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandlerThread.quit();
    }

    public class MyPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public ImageView instantiateItem(ViewGroup container, int position) {
            ImageView iv = mImageViews.get(position);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
