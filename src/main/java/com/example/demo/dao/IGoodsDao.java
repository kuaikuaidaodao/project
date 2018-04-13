package com.example.demo.dao;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
public interface IGoodsDao {

    List<Object[]> findGoodsEnglish(Long menuId);

    List findByCategoryId(String s);

    List findAll(int page);
}
