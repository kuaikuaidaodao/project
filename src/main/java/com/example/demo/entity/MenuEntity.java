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
@Table(name="menu")
public class MenuEntity {
    /**
     * id
     */
    private  Long menuId;
    /**
     * 菜单名——中文
     */
    private  String menuNameChinese;
    /**
     * 菜单名——english
     */
    private  String menuNameEnglish;
    /**
     * 父id
     */
    private  Long parentId;
    /**
     * url
     */
    private  String url;
    /**
     * 排序
     */
    private  int sort;

    /**
     * 无参构造方法
     */
    public MenuEntity() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "menu_id", nullable = false, precision = 0 )
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    @Basic
    @Column(name = "menu_name_chinese")
    public String getMenuNameChinese() {
        return menuNameChinese;
    }

    public void setMenuNameChinese(String menuNameChinese) {
        this.menuNameChinese = menuNameChinese;
    }
    @Basic
    @Column(name = "menu_name_english")
    public String getMenuNameEnglish() {
        return menuNameEnglish;
    }

    public void setMenuNameEnglish(String menuNameEnglish) {
        this.menuNameEnglish = menuNameEnglish;
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
