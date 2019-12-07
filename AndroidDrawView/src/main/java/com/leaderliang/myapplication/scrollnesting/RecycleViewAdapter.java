package com.leaderliang.myapplication.scrollnesting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leaderliang.myapplication.R;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/11 20:31
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHoler> implements View.OnClickListener {
    int ResourceID;
    Context mContext;
    ArrayList<String> mData;
    private OnRecycleViewItemClickListener mOnItemClickListener;

    public RecycleViewAdapter(Context context, int resourceID, ArrayList<String> brings) {
        mContext = context;
        mData = brings;
        ResourceID = resourceID;
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder, int position) {

    }

    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        //负责创建视图
        View view = LayoutInflater.from(mContext).inflate(ResourceID, null);
        view.setOnClickListener(this);
        return new MyViewHoler(view);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.OnItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecycleViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static interface OnRecycleViewItemClickListener {
        void OnItemClick(View view, int position);
    }

    class MyViewHoler extends RecyclerView.ViewHolder {
        private final TextView tvToolName;
        private final ImageView ivCheck;

        public MyViewHoler(View itemView) {
            super(itemView);
            tvToolName = itemView.findViewById(R.id.tv_toolname);
            ivCheck = itemView.findViewById(R.id.iv_check);

        }
    }


}