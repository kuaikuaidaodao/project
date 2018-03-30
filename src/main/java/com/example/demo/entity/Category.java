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
     * 菜单名——english
     */
    private  String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long menuId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
