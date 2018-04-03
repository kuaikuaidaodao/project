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
     * url
     */
    private  String url;
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
    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
