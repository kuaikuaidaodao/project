package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.PhotoEn;
/**
 *  
 * @author xwj
 * @date 2018年4月8日 上午9:26:59
 * @desc 画册
 */
public interface IPhotoDao {

	/**
	 * 查询全部画册
	 * @return
	 */
	List<PhotoEn> findAll();
	
}
