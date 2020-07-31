package com.example.musicdemo.activitys;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.example.musicdemo.R;

public class BaseActivity extends Activity {
    private ImageView mIvBack,mIvMe;
    private TextView mTvTitle;

    /**
     * findViewById
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id){
        return findViewById(id);
    }

    /**
     * 初始化 NavigationBar
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected  void initNavBar (boolean isShowBack,String title,boolean isShowMe){
        mIvBack = fd(R.id.iv_back);
        mIvMe = fd(R.id.iv_me);
        mTvTitle=fd(R.id.tv_title);
/**
 * 判断返回图片和我的图片是否显示isShowBack  isShowMe
 * 题目传入的值是什么则显示什么title
 */
        mIvBack.setVisibility(isShowBack ? View.VISIBLE :  View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE :  View.GONE);
        mTvTitle.setText(title);
        /**
         * mIvBack设置点击事件
         */
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this,MeActivity.class));
            }
        });
    }
}
