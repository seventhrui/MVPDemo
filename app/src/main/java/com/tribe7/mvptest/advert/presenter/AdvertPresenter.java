package com.tribe7.mvptest.advert.presenter;

import com.tribe7.mvptest.advert.model.AdvertModel;
import com.tribe7.mvptest.advert.model.AdvertModelImpl;
import com.tribe7.mvptest.advert.view.AdvertView;
import com.tribe7.mvptest.bean.AdBean;

import java.util.List;

/**
 * Created by admin on 2016/8/11.
 */

public class AdvertPresenter implements AdvertPresenterImpl, AdvertModel.OnLoadNewsListListener {
    private AdvertView advertview;
    private AdvertModelImpl advertmodelimpl;

    public AdvertPresenter(AdvertView advertview){
        this.advertview = advertview;
        this.advertmodelimpl = new AdvertModel();
    }

    @Override
    public void loadNews(String type) {
        String url = "http://192.168.0.70/7official/api.php/Advert/getAddList";
        advertmodelimpl.loadAdvert(url, type, this);
    }

    @Override
    public void onSuccess(List<AdBean> list) {
        advertview.addADverts(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
