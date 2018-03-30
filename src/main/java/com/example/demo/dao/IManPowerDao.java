package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ManPowerEn;
/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午5:04:20
 * @desc 人力资源
 */
public interface IManPowerDao {

	List<ManPowerEn> findAll();	
}
