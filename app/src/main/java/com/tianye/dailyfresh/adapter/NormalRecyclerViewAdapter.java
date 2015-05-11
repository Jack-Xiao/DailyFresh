package com.tianye.dailyfresh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianye.dailyfresh.R;
import com.tianye.dailyfresh.util.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2015/5/5.
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String [] mTitle;

    public static enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    public NormalRecyclerViewAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mTitle = context.getResources().getStringArray(android.R.array.emailAddressTypes);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text,parent,false));
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_cardview,null));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(mTitle[position]);
    }

    @Override
    public int getItemCount(){
        return mTitle.length;
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.title)
        TextView mTextView;
        @InjectView(R.id.img)
        ImageView mImageView;


        public NormalTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showLong("click item                  ................");
                }
            });
        }
    }
}
