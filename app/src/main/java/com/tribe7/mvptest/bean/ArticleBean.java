package com.tribe7.mvptest.bean;

import com.tribe7.mvptest.base.BaseBean;

/**
 * Created by admin on 2016/8/22.
 */

public class ArticleBean extends BaseBean {
    private int id;
    private String title;
    private String content;
    private String time;
    private int cate_id;
    private int user_id;
    private int hits;
    private int comments;
    private int type;

    public ArticleBean(int id, String title, String content, String time, int cate_id, int user_id, int hits, int comments, int type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.cate_id = cate_id;
        this.user_id = user_id;
        this.hits = hits;
        this.comments = comments;
        this.type = type;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
