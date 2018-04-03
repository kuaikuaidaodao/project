package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.biz.INewsService;
import com.example.demo.dao.INewsDao;
import com.example.demo.entity.News;
import com.example.demo.entity.NewsEn;
@Service
public class NewsServiceImpl implements INewsService{
	@Autowired
	private INewsDao newsDao;

	@Override
	public List<NewsEn> findById(Long id) {
		// TODO Auto-generated method stub
		return newsDao.findById(id);
	}

	@Override
	public List<NewsEn> findAll(Long type) {
		// TODO Auto-generated method stub
		return newsDao.findAll(type);
	}

	@Override
	public List<News> findAllByType(Long type) {
		// TODO Auto-generated method stub
		return newsDao.findAllByType(type);
	}

}
