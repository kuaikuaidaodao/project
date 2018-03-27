package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IFileDao;
import com.example.demo.dao.IFileRepository;
import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月27日 下午3:55:59
 * @desc 文件管理
 */
@Repository
public class FileDao implements IFileDao {

	@Autowired
	IFileRepository fileRepository;
	
	/**
	 * 查询所有区分中英文
	 */
	@Override
	public List<FileEn> findAll() {
		
		List<Object[]> list = fileRepository.findAllByZh();
		List<FileEn> file = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			FileEn fileEn = new FileEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				fileEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				fileEn.setFileName(obj[1].toString());
			}
			if (obj[2] != null) {
				fileEn.setFileUrl(obj[2].toString());
			}
			if (obj[3] != null) {
				fileEn.setImgUrl(obj[3].toString());
			}
			file.add(fileEn);
		}
		return file;
	}

	/**
	 * 查询单个区分中英文
	 */
	@Override
	public List<FileEn> findById(Long id) {
		
		List<Object[]> list = fileRepository.findOneByZh(id);
		List<FileEn> file = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			FileEn fileEn = new FileEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				fileEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				fileEn.setFileName(obj[1].toString());
			}
			if (obj[2] != null) {
				fileEn.setFileUrl(obj[2].toString());
			}
			if (obj[3] != null) {
				fileEn.setImgUrl(obj[3].toString());
			}
			file.add(fileEn);
		}
		return file;

	}
}
