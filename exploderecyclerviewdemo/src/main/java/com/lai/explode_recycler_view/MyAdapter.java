package com.lai.explode_recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lai on 2017/6/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHodelr> {
    private List<String> mData;
    private SetOnItemClickListener mListener;

    public MyAdapter(List<String> datas) {
        mData = datas;
    }

    //删除所有数据
    public void removeDatas(){
        mData = null;
        notifyDataSetChanged();
    }

    @Override
    public MyHodelr onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mView = View.inflate(viewGroup.getContext(), R.layout.item, null);
        MyHodelr myHodelr = new MyHodelr(mView, i);
        return myHodelr;
    }

    @Override
    public void onBindViewHolder(MyHodelr myHodelr, int i) {
        myHodelr.getTitle().setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public class MyHodelr extends RecyclerView.ViewHolder {
        TextView title;

        public MyHodelr(View itemView, final int i) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv);

            //item点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onItemClick(i);
                    }
                }
            });
        }

        public TextView getTitle() {
            return title;
        }
    }

    public void setListener(SetOnItemClickListener listener) {
        mListener = listener;
    }

    public interface SetOnItemClickListener {
        void onItemClick(int Position);
    }
}
