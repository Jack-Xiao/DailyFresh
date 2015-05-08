package com.tianye.dailyfresh.ui;

import android.content.Intent;
import android.os.Bundle;

import com.tianye.dailyfresh.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2015/5/8.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.img_wb)
    void OnClickWB(){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    @OnClick(R.id.img_wx)
    void OnClickWX(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

}
