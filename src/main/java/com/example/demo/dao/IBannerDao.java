package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.BannerEn;
/**
 * 
 * @author xwj
 * @date 2018年3月27日 下午3:57:41
 * @desc banner图
 */
public interface IBannerDao {

	/**
	 * 查询所有英文版banner图
	 * @return
	 */
	List<BannerEn> findAll();
}
