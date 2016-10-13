package com.tribe7.mvptest.advert.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.tribe7.convenientbanner.ConvenientBanner;
import com.tribe7.convenientbanner.holder.CBViewHolderCreator;
import com.tribe7.convenientbanner.listener.OnItemClickListener;
import com.tribe7.mvptest.R;
import com.tribe7.mvptest.advert.presenter.AdvertPresenter;
import com.tribe7.mvptest.advert.presenter.AdvertPresenterImpl;
import com.tribe7.mvptest.advert.view.AdvertView;
import com.tribe7.mvptest.advert.view.NetworkImageHolderView;
import com.tribe7.mvptest.base.BaseFragment;
import com.tribe7.mvptest.bean.AdBean;

import java.util.List;

/**
 * Created by admin on 2016/8/9.
 */
public class AdvertFragment extends BaseFragment implements AdvertView {
    private ConvenientBanner convenientBanner;//顶部广告栏控件
    private List<AdBean> adlist;

    private AdvertPresenterImpl advertpresenterimpl;

    private static AdvertFragment fragment;

    public static AdvertFragment getFragment() {
        if (fragment == null)
            fragment = new AdvertFragment();
        return fragment;
    }


    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_tribal, null);
        convenientBanner = (ConvenientBanner) rootView.findViewById(R.id.convenientBanner);
        return rootView;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        advertpresenterimpl = new AdvertPresenter(this);
        advertpresenterimpl.loadNews("2");
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void addADverts(List<AdBean> list) {
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, list).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});
    }
}
