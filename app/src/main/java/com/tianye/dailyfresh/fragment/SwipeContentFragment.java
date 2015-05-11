package com.tianye.dailyfresh.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianye.dailyfresh.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lenovo on 2015/5/11.
 */
public class SwipeContentFragment extends BaseFragment {
    private static final String TAG = "SwipeContentFragment";

    public static final String ARG_POSITION = "position";

    private int position;

    @InjectView(R.id.recycler_view)
    RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View contentView = inflater.inflate(R.layout.fragment_swap, container, false);
        ButterKnife.inject(this,contentView);

        parserArgument();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//这里用线性显示 类似于listview
        //        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        //mRecyclerView.setAdapter();




        //动态添加布局示例
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.MATCH_PARENT);
//
//        FrameLayout fl = new FrameLayout(getActivity());
//        fl.setLayoutParams(params);
//        fl.setBackgroundResource(drawables[position]);
//        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
//                .getDisplayMetrics());
//
//        TextView v = new TextView(getActivity());
//        params.setMargins(margin, margin, margin, margin);
//        v.setLayoutParams(params);
//        v.setLayoutParams(params);
//        v.setGravity(Gravity.BOTTOM);
//        v.setText("CARD " + (position + 1));
//
//        fl.addView(v);

//        return fl;

        return contentView;
    }

    private void parserArgument() {
        Bundle b = new Bundle();
        this.position = b.getInt(ARG_POSITION);
    }

    public static BaseFragment newInstance(int position){
        SwipeContentFragment fragment = new SwipeContentFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        fragment.setArguments(b);
        return fragment;
    }


}
