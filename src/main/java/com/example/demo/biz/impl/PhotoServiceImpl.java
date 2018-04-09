package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IPhotoService;
import com.example.demo.dao.IPhotoDao;
import com.example.demo.entity.PhotoEn;

@Service
public class PhotoServiceImpl implements IPhotoService{
	
	@Autowired
	IPhotoDao photoDao;

	@Override
	public List<PhotoEn> findAll() {
		// TODO Auto-generated method stub
		return photoDao.findAll();
	}

	

}
