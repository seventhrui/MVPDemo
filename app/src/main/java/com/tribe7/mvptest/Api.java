package com.tribe7.mvptest;

/**
 * Created by admin on 2016/8/23.
 */
public class Api {
    public static final String FINAL_SERVER = "http://116.255.191.114/7official/";
    public static final String TEST_SERVER = "http://192.168.0.70/7official/";

    public static String SERVER_URL = App.IS_DEBUG ? TEST_SERVER : FINAL_SERVER;

    /**
     * APP自动升级
     * GET
     */
    public static final String GET_APP_VERSION =  SERVER_URL + "api.php/app/app_version";
    /**
     * 广告列表
     * POST
     * Param
     *      position
     */
    public static final String GET_ADVERT_LIST = SERVER_URL + "api.php/Advert/getaddlist";
    /**
     * 文章列表
     * POST
     * Param
     *      type,
     *      page,
     *      pagesize
     */
    public static final String POST_ARTICLE_LIST =  SERVER_URL + "api.php/post/getpostlist";
    /**
     * 文章详情
     * GET or POST
     * Param
     *      id
     */
    public static final String GET_ARTICLE_DESC = SERVER_URL + "api.php/post/getpostdesc";
}
