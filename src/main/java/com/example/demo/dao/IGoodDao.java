package com.example.demo.dao;

import com.example.demo.entity.GoodEntity;
import com.example.demo.entity.UserinfoEntity;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
public interface IGoodDao {
    List<GoodEntity> selectBySecondId(Long second_id);
}
