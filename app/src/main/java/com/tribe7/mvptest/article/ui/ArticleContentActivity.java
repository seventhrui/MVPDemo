package com.tribe7.mvptest.article.ui;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.base.BaseActivity;

/**
 * Created by admin on 2016/8/26.
 */
public class ArticleContentActivity extends BaseActivity {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private ImageView mDetailImage;
    private TextView mDetailTitle;
    private TextView mDetailSource;
    private WebView mWebView;
    private ActionBar mActionBar;

    @Override
    public void initView() {
        setContentView(R.layout.activity_article_content);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.coll_toolbar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDetailImage = (ImageView) findViewById(R.id.detail_image);
        mDetailTitle = (TextView) findViewById(R.id.detail_title);
        mDetailSource = (TextView) findViewById(R.id.detail_source);
        mWebView = (WebView) findViewById(R.id.detail_web_view);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
        mCollapsingToolbarLayout.setTitleEnabled(true);
        mActionBar.setTitle("");
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }
}
