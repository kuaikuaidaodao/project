package com.example.demo.dao;

import com.example.demo.entity.PolicyEntity;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:21
 * @desc des
 **/
public interface IPolicyDao {

    List<PolicyEntity>  getPolicyByClassify(String classify);


List<PolicyEntity> selectByim(String hql, String startDate, String endDate, String organization);
}
