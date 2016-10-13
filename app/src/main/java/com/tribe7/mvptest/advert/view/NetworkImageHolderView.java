package com.tribe7.mvptest.advert.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.tribe7.convenientbanner.holder.Holder;
import com.tribe7.mvptest.bean.AdBean;
import com.tribe7.mvptest.utils.ImageLoaderUtils;
import com.tribe7.mvptest.webview.WebViewActivity;


/**
 * 网络图片加载View
 */
public class NetworkImageHolderView implements Holder<AdBean> {
    private Context context;
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        this.context = context;
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(final Context context, int position, final AdBean data) {
        ImageLoaderUtils.display(context, imageView, data.getImgsrc());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件
                Intent intent = new Intent();
                intent.setClass(context, WebViewActivity.class);
                intent.putExtra("title", data.getTitle());
                intent.putExtra("url", data.getUrl());
                context.startActivity(intent);
            }
        });
    }
}
