package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.biz.IVideoService;
import com.example.demo.dao.IVideoDao;
import com.example.demo.entity.VideoEn;
@Service
public class VideoServiceImpl implements IVideoService{

	@Autowired
	IVideoDao videoDao;

	@Override
	public List<VideoEn> findAll() {
		// TODO Auto-generated method stub
		return videoDao.findAll();
	}
}
