package com.example.demo.dao;

import com.example.demo.entity.cityinfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:21
 * @desc des
 **/
public interface ICityinfoDao {
    Object getType();


//    根据类型查信息
    List<cityinfoEntity> getInfoByType(String classify);
//查审核已通过的
    List<cityinfoEntity> findCheck();
    //查审核未通过的
    List<cityinfoEntity> findNoCheck();
}
