package com.example.demo.entity;

/**
 * @author li
 * @create 2018-03-27 9:42
 * @desc 英文
 **/
public class Category {
    /**
     * id
     */
    private  Long categoryId;
    /**
     * 类名——english
     */
    private  String categoryName;
    /**
     * url
     */
    private  String url;

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
