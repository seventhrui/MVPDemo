package com.tribe7.mvptest.main.presenter;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.main.view.MainView;

/**
 * Created by admin on 2016/8/9.
 */

public class MainPresenter implements MainPresenterImpl {
    private MainView mainView;

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id){
            case R.id.re_weixin:
                mainView.switch2Advert();
                break;
            case R.id.re_contact_list:
                mainView.switch2Article();
                break;
            case R.id.re_find:
                mainView.switch2Find();
                break;
            case R.id.re_profile:
                mainView.switch2Mine();
                break;
            default:
                mainView.switch2Advert();
                break;
        }
    }
}
