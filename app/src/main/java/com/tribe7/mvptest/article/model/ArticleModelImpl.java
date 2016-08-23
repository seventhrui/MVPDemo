package com.tribe7.mvptest.article.model;

/**
 * Created by admin on 2016/8/22.
 */
public interface ArticleModelImpl {
    void loadArticle(String url, int cateid, int page, int pagesize, ArticleModel.OnLoadArticleListListener listener);
}
