package com.lai.www.textinputlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TextInputActivity extends AppCompatActivity {

    private EditText mUserEt;
    private EditText mPwdEt;
    private LinearLayout mActivityTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        initView();

    }

    private void initView() {
        mUserEt = (EditText) findViewById(R.id.user_et);
        mPwdEt = (EditText) findViewById(R.id.pwd_et);

//        mUserEt.setHint("账号: ");
//        mPwdEt.setHint("密码: ");
    }

    public void click(View view) {
        mPwdEt.setError("不能为空!!!");
    }
}
