package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.INewsDao;
import com.example.demo.dao.INewsRepository;
import com.example.demo.entity.FileEn;
import com.example.demo.entity.News;
import com.example.demo.entity.NewsEn;
@Repository
public class NewsDao implements INewsDao{
	@Autowired
	private INewsRepository newsRepository;

	@Override
	public List<NewsEn> findById(Long id) {
		List<Object[]> list = newsRepository.findOneByZh(id);
		List<NewsEn> news = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			NewsEn newsEn = new NewsEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				newsEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				newsEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				newsEn.setContext(obj[2].toString());
			}
			if (obj[3] != null) {
				newsEn.setImgurl(obj[3].toString());
			}
			if (obj[4] != null) {
				newsEn.setWriter(obj[4].toString());
			}
			if (obj[5] != null) {
				newsEn.setResource(obj[5].toString());
			}
			if (obj[6] != null) {
				newsEn.setTime(obj[5].toString());
			}
			if (obj[7] != null) {
				newsEn.setType(Long.valueOf(obj[7].toString()));
			}
			news.add(newsEn);
		}
		return news;
	}

	@Override
	public List<NewsEn> findAll(Long type) {
		List<Object[]> list = newsRepository.findAllByZh(type);
		List<NewsEn> news = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			NewsEn newsEn = new NewsEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				newsEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				newsEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				newsEn.setContext(obj[2].toString());
			}
			if (obj[3] != null) {
				newsEn.setImgurl(obj[3].toString());
			}
			if (obj[4] != null) {
				newsEn.setWriter(obj[4].toString());
			}
			if (obj[5] != null) {
				newsEn.setResource(obj[5].toString());
			}
			if (obj[6] != null) {
				newsEn.setTime(obj[5].toString());
			}
			if (obj[7] != null) {
				newsEn.setType(Long.valueOf(obj[7].toString()));
			}
			news.add(newsEn);
		}
		return news;
	}

	@Override
	public List<News> findAllByType(Long type) {
		List<Object[]> list = newsRepository.findAllByType(type);
		List<News> news = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			News newsEn = new News();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				newsEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				newsEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				newsEn.setNameEn(obj[2].toString());
			}
			if (obj[3] != null) {
				newsEn.setContext(obj[3].toString());
			}
			if (obj[4] != null) {
				newsEn.setContextEn(obj[4].toString());
			}
			if (obj[5] != null) {
				newsEn.setImgurl(obj[5].toString());
			}
			if (obj[6] != null) {
				newsEn.setWriter(obj[6].toString());
			}
			if (obj[7] != null) {
				newsEn.setWriterEn(obj[7].toString());
			}
			if (obj[8] != null) {
				newsEn.setResource(obj[8].toString());
			}
			if (obj[9] != null) {
				newsEn.setResourceEn(obj[9].toString());
			}
			if (obj[10] != null) {
				newsEn.setTime(obj[10].toString());
			}
			if (obj[11] != null) {
				newsEn.setType(Long.valueOf(obj[11].toString()));
			}
			news.add(newsEn);
		}
		return news;
	}

}
