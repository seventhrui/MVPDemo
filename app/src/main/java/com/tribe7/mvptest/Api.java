package com.tribe7.mvptest;

/**
 * Created by admin on 2016/8/23.
 */
public class Api {
    public static final String FINAL_SERVER = "http://116.255.191.114/7official/";
    public static final String TEST_SERVER = "http://192.168.0.70/7official/";

    public static String SERVER_URL = App.IS_DEBUG ? TEST_SERVER : FINAL_SERVER;

    public static final String GET_ADVERT_LIST = SERVER_URL + "api.php/Advert/getAddList";
    public static final String POST_ARTICLE_LIST =  SERVER_URL + "api.php/post/getPostList";
    public static final String GET_APP_VERSION =  SERVER_URL + "api.php/App/app_version";
}
