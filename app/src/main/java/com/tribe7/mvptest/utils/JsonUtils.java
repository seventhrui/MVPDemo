package com.tribe7.mvptest.utils;

import com.tribe7.mvptest.bean.AdBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/11.
 */

public class JsonUtils {
    /**
     * 将获取到的json转换为新闻列表对象
     * @param res
     * @return
     */
    public static List<AdBean> readJsonNewsBeans(String res) {
        List<AdBean> beans = new ArrayList<AdBean>();
        try {
            JSONObject json = new JSONObject(res);
            int code = json.optInt("code");
            if(code == 1){
                JSONArray jsonarray = json.optJSONArray("data");
                int length = jsonarray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject defectJson = jsonarray.getJSONObject(i);
                    int id = defectJson.optInt("id");        //id
                    String title = defectJson.optString("title");  //标题
                    int position = defectJson.optInt("position");  //位置
                    int type = defectJson.optInt("type");      //类型
                    String url = defectJson.optString("url");    //跳转条件
                    String imgsrc = defectJson.optString("imgsrc"); //图片路径
                    int imgwidth = defectJson.optInt("imgwidth");  //图片宽度
                    int imgheight = defectJson.optInt("imgheight"); //图片高度
                    int sort = defectJson.optInt("sort");      //广告排序
                    beans.add(new AdBean(id, title, position, type, url, imgsrc, imgwidth, imgheight, sort));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
