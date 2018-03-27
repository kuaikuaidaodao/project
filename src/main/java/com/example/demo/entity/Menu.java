package com.example.demo.entity;

import javax.persistence.Entity;

/**
 * @author li
 * @create 2018-03-27 9:42
 * @desc 英文
 **/
public class Menu {
    /**
     * id
     */
    private  Long menuId;
    /**
     * 菜单名——english
     */
    private  String menuName;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
