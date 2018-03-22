package com.example.demo.dao;

import com.example.demo.entity.UserinfoEntity;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
public interface IUserinfoDao {
    List<UserinfoEntity> selectByNameAndPassword(String name, String password);
}
