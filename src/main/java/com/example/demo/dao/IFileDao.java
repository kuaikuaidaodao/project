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

	List<FileEn> findById(Long id);
	
	List<FileEn> findAll();
}
