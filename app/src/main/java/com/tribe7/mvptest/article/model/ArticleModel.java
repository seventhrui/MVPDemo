package com.tribe7.mvptest.article.model;

import com.tribe7.mvptest.bean.ArticleBean;
import com.tribe7.mvptest.utils.JsonUtils;
import com.tribe7.mvptest.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/22.
 */
public class ArticleModel implements ArticleModelImpl {
    @Override
    public void loadArticle(String url, int type, int page, int pagesize, final OnLoadArticleListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<ArticleBean> newsBeanList = JsonUtils.readJsonArticleBeans(response);
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("加载失败", e);
            }
        };
        List<OkHttpUtils.Param> param = new ArrayList<OkHttpUtils.Param>();
        param.add(new OkHttpUtils.Param("type", type+""));
        param.add(new OkHttpUtils.Param("page", page+""));
        param.add(new OkHttpUtils.Param("pagesize", pagesize+""));
        OkHttpUtils.post(url, loadNewsCallback, param);
    }

    public interface OnLoadArticleListListener {
        void onSuccess(List<ArticleBean> list);
        void onFailure(String msg, Exception e);
    }
}