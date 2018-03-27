package com.example.demo.dao;

import com.example.demo.entity.*;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
public interface ICatalogDao {


    List<MenuEntity> findAllByEnglish();

    List<Menu> findAllByChinese();
}
