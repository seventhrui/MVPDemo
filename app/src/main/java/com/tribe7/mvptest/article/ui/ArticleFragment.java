package com.tribe7.mvptest.article.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.article.ArticleAdapter;
import com.tribe7.mvptest.article.presenter.ArticlePresenterImpl;
import com.tribe7.mvptest.article.presenter.ArticlePressenter;
import com.tribe7.mvptest.article.view.ArticleView;
import com.tribe7.mvptest.base.BaseFragment;
import com.tribe7.mvptest.bean.ArticleBean;
import com.tribe7.mvptest.widget.ListItemDecoration;
import com.tribe7.mvptest.widget.SwipeRefreshLoadLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/9.
 */
public class ArticleFragment extends BaseFragment implements ArticleView {
    private List<ArticleBean> arlist;
    private ArticlePresenterImpl articlepresenterimpl;

    public static ArticleFragment fragment;
    private SwipeRefreshLoadLayout mSwipeRefreshWidget;
    private RecyclerView recyclerview;

    private int cateid;
    private int page;
    private int pagesize;
    private ArticleAdapter adapter;

    public static ArticleFragment getFragment(){
        if (fragment == null)
            fragment = new ArticleFragment();
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_article, null);
        mSwipeRefreshWidget = (SwipeRefreshLoadLayout) rootView.findViewById(R.id.swipe_refresh_widget);
        recyclerview = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        return rootView;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                                                    R.color.primary_dark,
                                                    R.color.primary_light,
                                                    R.color.accent);

        arlist = new ArrayList<ArticleBean>();
        adapter = new ArticleAdapter(context, arlist);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(context));
        // 设置item分
        recyclerview.addItemDecoration(new ListItemDecoration(context, LinearLayoutManager.VERTICAL));
        // 设置item动画
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        articlepresenterimpl = new ArticlePressenter(this);
        articlepresenterimpl.loadArticle(cateid, page, pagesize);
    }

    @Override
    protected void setListener() {

    }


    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void addArticle(List<ArticleBean> list) {
        arlist.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showLoadFailMsg(String msg) {

    }
}
