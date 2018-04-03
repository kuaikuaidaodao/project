package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.News;
import com.example.demo.entity.NewsEn;
/**
 * 
 * @author xwj
 * @date 2018年4月3日 上午10:08:47
 * @desc 新闻
 */
public interface INewsDao {

	/**
	 *  根据id查询新闻英文
	 * @param id
	 * @return
	 */
	List<NewsEn> findById(Long id);
	
	/**
	 *  查询所有英文版新闻
	 * @param id
	 * @return
	 */
	List<NewsEn> findAll(Long type);
	
	/**
	 * 查询所有的新闻
	 * @return
	 */
	List<News> findAllByType(Long type);
}
