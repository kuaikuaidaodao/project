package com.example.demo.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(categoryId, categoryName);
    }
}
