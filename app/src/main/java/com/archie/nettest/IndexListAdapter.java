package com.archie.nettest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Jarchie on 2018\2\12.
 * 列表数据适配器
 */

public class IndexListAdapter extends RecyclerView.Adapter<IndexListAdapter.ViewHolder> {
    private List<MovieBean.DataBean.MoviesBean> mList;
    private Context mContext;

    public IndexListAdapter(Context context, List<MovieBean.DataBean.MoviesBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_index_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mShowInfo.setText(mList.get(position).getShowInfo());
        holder.mName.setText(mList.get(position).getNm());
        holder.mCat.setText(mList.get(position).getCat());
        Glide.with(mContext).load(mList.get(position).getImg()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mShowInfo, mName, mCat;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.index_image);
            mShowInfo = itemView.findViewById(R.id.item_index_showinfo);
            mName = itemView.findViewById(R.id.item_index_name);
            mCat = itemView.findViewById(R.id.item_index_cat);
        }
    }

}
