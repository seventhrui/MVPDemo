package com.tribe7.mvptest.advert.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.tribe7.convenientbanner.holder.Holder;
import com.tribe7.mvptest.bean.AdBean;
import com.tribe7.mvptest.utils.ImageUtils;


/**
 * 网络图片加载例子
 */
public class NetworkImageHolderView implements Holder<AdBean> {
private ImageView imageView;
@Override
public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
        }

@Override
public void UpdateUI(Context context,int position, AdBean data) {
        ImageUtils.getBinnerBitmap(imageView, data.getImgsrc());
    }
}
