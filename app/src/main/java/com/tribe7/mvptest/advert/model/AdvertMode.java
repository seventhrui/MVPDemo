package com.tribe7.mvptest.advert.model;

import com.tribe7.mvptest.bean.AdBean;
import com.tribe7.mvptest.utils.JsonUtils;
import com.tribe7.mvptest.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/11.
 */

public class AdvertMode implements AdvertModelImpl {

    @Override
    public void loadAdvert(String url, String type, final AdvertMode.OnLoadNewsListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<AdBean> newsBeanList = JsonUtils.readJsonNewsBeans(response);
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.", e);
            }
        };
        //OkHttpUtils.get(url, loadNewsCallback);
        List<OkHttpUtils.Param> param = new ArrayList<OkHttpUtils.Param>();
        param.add(new OkHttpUtils.Param("position", type));
        OkHttpUtils.post(url, loadNewsCallback, param);
    }

    public interface OnLoadNewsListListener {
        void onSuccess(List<AdBean> list);
        void onFailure(String msg, Exception e);
    }
}
