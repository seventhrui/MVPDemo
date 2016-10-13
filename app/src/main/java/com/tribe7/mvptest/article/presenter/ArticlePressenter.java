package com.tribe7.mvptest.article.presenter;

import com.tribe7.mvptest.Api;
import com.tribe7.mvptest.article.model.ArticleModel;
import com.tribe7.mvptest.article.model.ArticleModelImpl;
import com.tribe7.mvptest.article.view.ArticleView;
import com.tribe7.mvptest.bean.ArticleBean;

import java.util.List;

/**
 * Created by admin on 2016/8/22.
 */
public class ArticlePressenter implements ArticlePresenterImpl, ArticleModel.OnLoadArticleListListener {
    private ArticleView articleview;
    private ArticleModelImpl articlemodelimpl;

    public ArticlePressenter(ArticleView view){
        this.articleview = view;
        this.articlemodelimpl = new ArticleModel();
    }

    @Override
    public void loadArticle(int cateid, int page, int pagsize) {
        String url = Api.POST_ARTICLE_LIST;
        articleview.showProgress();
        articlemodelimpl.loadArticle(url, cateid, page, pagsize, this);
    }

    @Override
    public void onSuccess(List<ArticleBean> list) {
        if(list.size()>0) {
            articleview.addArticle(list);
        }else{
            articleview.showNoMoreData();
        }
        articleview.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        articleview.hideProgress();
        articleview.showLoadFailMsg(msg);
    }
}
