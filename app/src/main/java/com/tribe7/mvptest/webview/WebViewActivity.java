package com.tribe7.mvptest.webview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.base.BaseActivity;
import com.tribe7.mvptest.widget.ProgressWebView;

/**
 * @author app
 * @version V1.0
 * @time 2016-05-13 17:35.
 * @description 加载网页
 */
public class WebViewActivity extends BaseActivity {
    private ProgressWebView mWebView;
    private String url;
    
    @Override
    public void initView() {
        mWebView = new ProgressWebView(this);
    }

    @Override
    public void initData() {
        String title = getIntent().getExtras().getString("title");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(true);

        url = getIntent().getExtras().getString("url");
        mWebView.loadUrl(url);
        setContentView(mWebView);
    }

    @Override
    public void setListener() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_webview_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.web_browser:
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.web_refresh:
                mWebView.loadUrl(url);
                break;
            case R.id.web_close:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
