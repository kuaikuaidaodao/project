package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author li
 * @create 2018-03-26 16:51
 * @desc 菜单
 **/
@Entity
@Table(name="category")
public class CategoryEntity {
    /**
     * id
     */
    private  Long categoryId;
    /**
     * 类名——中文
     */
    private  String categoryNameChinese;
    /**
     * 类名——english
     */
    private  String categoryNameEnglish;
    /**
     * 父id
     */
    private  Long parentId;
    /**
     * 排序
     */
    private  int sort;

    /**
     * 无参构造方法
     */
    public CategoryEntity() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "category_id", nullable = false, precision = 0 )
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    @Basic
    @Column(name = "category_name_chinese")
    public String getCategoryNameChinese() {
        return categoryNameChinese;
    }

    public void setCategoryNameChinese(String categoryNameChinese) {
        this.categoryNameChinese = categoryNameChinese;
    }
    @Basic
    @Column(name = "category_name_english")
    public String getCategoryNameEnglish() {
        return categoryNameEnglish;
    }

    public void setCategoryNameEnglish(String categoryNameEnglish) {
        this.categoryNameEnglish = categoryNameEnglish;
    }
    @Basic
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    @Basic
    @Column(name = "sort")
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return sort == that.sort &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(categoryNameChinese, that.categoryNameChinese) &&
                Objects.equals(categoryNameEnglish, that.categoryNameEnglish) &&
                Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(categoryId, categoryNameChinese, categoryNameEnglish, parentId, sort);
    }
}
