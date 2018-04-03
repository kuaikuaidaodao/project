package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.News;
import com.example.demo.entity.NewsEn;

public interface INewsService {

	/**
	 * 根据id查询新闻
	 * @param id
	 * @return
	 */
	List<NewsEn> findById(Long id);

	/**
	 * 查询所有的英文新闻
	 * @return
	 */
	List<NewsEn> findAll(Long type);
	
	/**
	 * 查询所有的新闻
	 * @return
	 */
	List<News> findAllByType(Long type);
}
