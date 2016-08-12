package com.tribe7.mvptest.bean;

/**
 * @author app
 * @version V1.0
 * @time 2016-05-11 15:32.
 * @description 广告
 */
public class AdBean {
    /** id     */
    private int id;
    /** 标题     */
    private String title;
    /** 位置     */
    private int position;
    /** 跳转类型     */
    private int type;
    /** 跳转路径/条件     */
    private String url;
    /** 图片路径     */
    private String imgsrc;
    /** 图片宽度     */
    private int imgwidth;
    /** 图片高度     */
    private int imgheight;
    /**
     * 广告排序
     * 数字越大优先级越高
     */
    private int sort;

    public AdBean() {
    }

    public AdBean(int id, String title, int position, int type, String url, String imgsrc, int imgwidth, int imgheight, int sort) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.type = type;
        this.url = url;
        this.imgsrc = imgsrc;
        this.imgwidth = imgwidth;
        this.imgheight = imgheight;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public int getImgwidth() {
        return imgwidth;
    }

    public void setImgwidth(int imgwidth) {
        this.imgwidth = imgwidth;
    }

    public int getImgheight() {
        return imgheight;
    }

    public void setImgheight(int imgheight) {
        this.imgheight = imgheight;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
