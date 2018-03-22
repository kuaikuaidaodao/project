package com.example.demo.dao;

import com.example.demo.entity.FirstlevelEntity;
import com.example.demo.entity.SecondlevelEntity;
import com.example.demo.entity.UserinfoEntity;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
public interface ICatalogDao {
//通过一级目录查二级目录
    List<SecondlevelEntity> findByFirstId(Long firstId);
}
