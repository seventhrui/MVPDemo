package com.tribe7.mvptest.article.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.article.ArticleAdapter;
import com.tribe7.mvptest.article.presenter.ArticlePresenterImpl;
import com.tribe7.mvptest.article.presenter.ArticlePressenter;
import com.tribe7.mvptest.article.view.ArticleView;
import com.tribe7.mvptest.base.BaseFragment;
import com.tribe7.mvptest.bean.ArticleBean;
import com.tribe7.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/9.
 */
public class ArticleFragment extends BaseFragment implements ArticleView {
    private List<ArticleBean> arlist;
    private ArticlePresenterImpl articlepresenterimpl;

    public static ArticleFragment fragment;
    private PullLoadMoreRecyclerView mSwipeRefreshWidget;
    private RecyclerView recyclerview;
    private FloatingActionButton fab_top;

    private int cateid;
    private static int page = 0;
    private final int pagesize = 10;
    private ArticleAdapter adapter;

    public static ArticleFragment getFragment(){
        if (fragment == null)
            fragment = new ArticleFragment();
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_article, null);
        mSwipeRefreshWidget = (PullLoadMoreRecyclerView) rootView.findViewById(R.id.swipe_refresh_widget);
        recyclerview = mSwipeRefreshWidget.getRecyclerView();
        fab_top = (FloatingActionButton) rootView.findViewById(R.id.fab_top);
        return rootView;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        //设置下拉刷新是否可见
        //mSwipeRefreshWidget.setRefreshing(true);
        //设置是否可以下拉刷新
        //mSwipeRefreshWidget.setPullRefreshEnable(true);
        //设置是否可以上拉刷新
        //mSwipeRefreshWidget.setPushRefreshEnable(false);
        //显示下拉刷新
        mSwipeRefreshWidget.setRefreshing(true);
        //设置上拉刷新文字
        mSwipeRefreshWidget.setFooterViewText("loading");
        //设置上拉刷新文字颜色
        mSwipeRefreshWidget.setFooterViewTextColor(R.color.white);
        //设置加载更多背景色
        mSwipeRefreshWidget.setFooterViewBackgroundColor(R.color.cardview_light_background);
        mSwipeRefreshWidget.setLinearLayout();

        mSwipeRefreshWidget.setOnPullLoadMoreListener(new PullLoadMoreListener());
        //setEmptyView
        mSwipeRefreshWidget.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.layout_empty_view, null));

        recyclerview.setVerticalScrollBarEnabled (true);

        arlist = new ArrayList<ArticleBean>();
        adapter = new ArticleAdapter(context, arlist);
        mSwipeRefreshWidget.setAdapter(adapter);

        articlepresenterimpl = new ArticlePressenter(this);
        articlepresenterimpl.loadArticle(cateid, page, pagesize);
    }

    class PullLoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener {
        @Override
        public void onRefresh() {
            refreshData();
        }

        @Override
        public void onLoadMore() {
            loadMoreData();
        }
    }

    @Override
    protected void setListener() {
        adapter.setOnItemClickListener(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(context, ArticleContentActivity.class);
                //startActivity(intent);
                View transitionView = view.findViewById(R.id.card_view);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), transitionView, getString(R.string.transition_news_img));
                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, "LongClick" + position, Toast.LENGTH_SHORT).show();
            }
        });

        fab_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerview.smoothScrollToPosition(0);
            }
        });

    }

    private void refreshData() {
        page = 0;
        if(arlist.size()>0) {
            arlist.clear();
        }
        articlepresenterimpl.loadArticle(cateid, page, pagesize);
    }
    private void loadMoreData() {
        articlepresenterimpl.loadArticle(cateid, page, pagesize);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setPullLoadMoreCompleted();
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setPullLoadMoreCompleted();
    }

    @Override
    public void addArticle(List<ArticleBean> list) {
        if(list.size()>0) {
            page++;
        }
        arlist.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoMoreData() {
        Snackbar.make(rootView, "没有更多数据", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadFailMsg(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
    }
}
