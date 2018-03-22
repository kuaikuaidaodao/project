package com.example.demo.biz;

import com.example.demo.entity.cityinfoEntity;


import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:52
 * @desc 城市信息
 **/
public interface ICityinfoService {
    Object getType();
    //查询全部
    List<cityinfoEntity> findAll();


    //删除
    void delete(String ids);
    //一条
     cityinfoEntity findOne(String id);
    //保存
    void saveAndflush(cityinfoEntity cityinfoEntity);


//   根据类型查信息

    List<cityinfoEntity> getInfoByType(String type);
//查审核通过的
    List<cityinfoEntity> findCheck();
    //查审核未通过的
    List<cityinfoEntity> findNoCheck();
}
