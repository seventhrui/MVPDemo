package com.tribe7.mvptest.advert.presenter;


import com.tribe7.mvptest.advert.model.AdvertMode;
import com.tribe7.mvptest.advert.model.AdvertModelImpl;
import com.tribe7.mvptest.advert.view.AdvertView;
import com.tribe7.mvptest.bean.AdBean;

import java.util.List;

/**
 * Created by admin on 2016/8/11.
 */

public class AdvertPresenter implements AdvertPresenterImpl, AdvertMode.OnLoadNewsListListener {
    private AdvertView advertview;
    private AdvertModelImpl advertmodelimpl;

    public AdvertPresenter(AdvertView advertview){
        this.advertview = advertview;
        this.advertmodelimpl = new AdvertMode();
    }

    @Override
    public void loadNews(int type) {
        String url = "http://116.255.191.114/api.php/Advert/getAddList";
        advertmodelimpl.loadAdvert(url, this);
    }

    @Override
    public void onSuccess(List<AdBean> list) {
        advertview.addADverts(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
