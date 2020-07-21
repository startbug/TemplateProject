package com.ggs.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`blog`")
public class Blog implements Serializable {
    /**
     * 博客id
     */
    @Id
    @Column(name = "`id`")
    private String id;

    /**
     * 博客标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 博客作者
     */
    @Column(name = "`author`")
    private String author;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 浏览量
     */
    @Column(name = "`views`")
    private Integer views;

    private static final long serialVersionUID = 1L;

    /**
     * 获取博客id
     *
     * @return id - 博客id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置博客id
     *
     * @param id 博客id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取博客标题
     *
     * @return title - 博客标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置博客标题
     *
     * @param title 博客标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取博客作者
     *
     * @return author - 博客作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置博客作者
     *
     * @param author 博客作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取浏览量
     *
     * @return views - 浏览量
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 设置浏览量
     *
     * @param views 浏览量
     */
    public void setViews(Integer views) {
        this.views = views;
    }
}