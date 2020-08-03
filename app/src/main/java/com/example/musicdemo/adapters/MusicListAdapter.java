package com.example.musicdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicdemo.R;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {
    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;
    public MusicListAdapter(Context context,RecyclerView recyclerView){
        mContext = context;
        mRv = recyclerView;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music,parent,false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setRecyclerViewHeight();
        Glide.with(mContext)
                .load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1596436866&di=a8af6e34ecc0ef1dd2cb63a2f02116ab&src=http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg")
                .into(holder.ivIcon);


    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 1.获取itemView的高度
     * 2.获取itemView的数量
     * 3.使用itemViewHeight*itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight(){
        if(isCalcaulationRvHeight ||mRv ==null) return;
        isCalcaulationRvHeight = true;
        // 获取itemView的高度
       RecyclerView.LayoutParams itemViewLp= (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        // 获取itemView的数量
        int itemCount = getItemCount();
        // 使用itemViewHeight*itemViewNum = RecyclerView的高度
        int recyclerViewHeight = itemViewLp.height * itemCount;
        // 设置RecyclerView的高度
        LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvLp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvLp);

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        ImageView ivIcon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
