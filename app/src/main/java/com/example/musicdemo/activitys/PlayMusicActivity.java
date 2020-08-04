package com.example.musicdemo.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.musicdemo.R;
import com.example.musicdemo.views.PlayMusicView;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {
    private ImageView mIvBg;
    private PlayMusicView mplayMusicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
    }
    private void initView(){
        mIvBg = fd(R.id.iv_bg);
        //glide-transformations
        //请求网络图片
        Glide.with(this)
                .load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1596436866&di=a8af6e34ecc0ef1dd2cb63a2f02116ab&src=http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25,10)))
                .into(mIvBg);
        mplayMusicView = fd(R.id.play_music_view);
        mplayMusicView.setMusicIcon("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1596436866&di=a8af6e34ecc0ef1dd2cb63a2f02116ab&src=http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg");
        mplayMusicView.playMusic("http://res.lgdsunday.club/Nostalgic%20Piano.mp3");
    }
    /**
     * 后退按钮点击事件
     * @param view
     */
    public void onBackClick(View view) {
        onBackPressed();
    }
}