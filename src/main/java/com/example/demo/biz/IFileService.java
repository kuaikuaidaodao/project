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

	List<FileEn> findById(Long id);

	List<FileEn> findAll();
}
