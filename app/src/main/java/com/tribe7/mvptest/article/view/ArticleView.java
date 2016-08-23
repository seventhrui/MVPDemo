package com.tribe7.mvptest.article.view;

import com.tribe7.mvptest.bean.ArticleBean;

import java.util.List;

/**
 * Created by admin on 2016/8/22.
 */
public interface ArticleView {
    void showProgress();
    void hideProgress();
    void addArticle(List<ArticleBean> list);
    void showNoMoreData();
    void showLoadFailMsg(String msg);
}
