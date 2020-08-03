package com.example.musicdemo.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.musicdemo.R;
import com.example.musicdemo.adapters.MusicGridAdapter;
import com.example.musicdemo.adapters.MusicListAdapter;
import com.example.musicdemo.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {
    private RecyclerView mRvGrid,mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        initNavBar(false,"萌兔音乐",true);
        mRvGrid = fd(R.id.iv_grid);
        // 第一个参数上下文  第二个参数 "3"代表在同一行中所展示的数量
        mRvGrid.setLayoutManager(new GridLayoutManager(this,3));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelOffset(R.dimen.albumMarginSize),mRvGrid));
       mRvGrid.setNestedScrollingEnabled(false);
        mGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(mGridAdapter);
        /**
         * 1.假如列表高度的情况下,可以直接在布局中把RecyclerView的高度定义上
         * 2.不知道列表高度的情况下,需要手动计算RecyclerView的高度
         */
        mRvList = fd(R.id.iv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mListAdapter = new MusicListAdapter(this,mRvList);
        mRvList.setAdapter(mListAdapter);

    }
}