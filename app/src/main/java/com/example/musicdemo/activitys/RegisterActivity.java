package com.example.musicdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.musicdemo.R;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    /**
     *初始化View
     */
    private void initView() {
        initNavBar(true,"注册",false);
    }

    public void onRegisterClick(View view) {
    }
}