package com.tribe7.mvptest.advert.model;

/**
 * Created by admin on 2016/8/11.
 */

public interface AdvertModelImpl {
    void loadAdvert(String url, String type, AdvertModel.OnLoadNewsListListener listener);
}
