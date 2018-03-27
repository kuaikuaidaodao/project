package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IFileService;
import com.example.demo.dao.IFileDao;
import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

/**
 * @author xwj
 * @date 2018年3月27日 下午3:52:37
 * @description 文件管理
 */
@Service
public class FileServiceImpl implements IFileService{

	@Autowired
	IFileDao fileDao;
	@Override
	public List<FileEn> findById(Long id) {
		// TODO Auto-generated method stub
		return fileDao.findById(id);
	}

	@Override
	public List<FileEn> findAll() {
		// TODO Auto-generated method stub
		return fileDao.findAll();
	}

}
