package com.tribe7.mvptest.mine.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.base.BaseFragment;

/**
 * Created by admin on 2016/8/9.
 */
public class MineFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_mine, null);
        return rootView;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
