package com.example.demo.dao;

import com.example.demo.entity.*;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
public interface ICatalogDao {
//通过一级目录查二级目录
    List<SecondlevelEntity> findByFirstId(Long firstId);

    List<MenuEntity> findAllByEnglish();

    List<Menu> findAllByChinese();
}
