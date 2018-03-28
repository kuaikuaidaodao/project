package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月27日 下午3:58:55
 * @desc 文件管理
 */
public interface IFileService {

	/**
	 * 根据id查询文件
	 * @param id
	 * @return
	 */
	List<FileEn> findById(Long id);

	/**
	 * 查询所有的文件
	 * @return
	 */
	List<FileEn> findAll();
}
