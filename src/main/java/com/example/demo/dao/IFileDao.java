package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;
/**
 * @author xwj
 * @date 2018年3月27日 下午3:54:38
 * @desc 文件管理
 */
public interface IFileDao {

	/**
	 *  根据id查询英文版文件管理
	 * @param id
	 * @return
	 */
	List<FileEn> findById(Long id);
	
	/**
	 *  查询所有英文版文件管理
	 * @param id
	 * @return
	 */
	List<FileEn> findAll();
}
