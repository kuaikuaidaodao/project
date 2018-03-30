package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.BedEn;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午3:36:56
 * @desc  游戏床
 */ 
public interface IBedDao {

	List<BedEn> findAll();
	
	List<BedEn> findById(Long id);
}
