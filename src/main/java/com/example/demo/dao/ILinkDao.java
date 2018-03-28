package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午9:39:58
 * @desc 友情链接
 */

import com.example.demo.entity.LinkEn;

public interface ILinkDao {

	/**
	 * 查询所有英文版友情链接
	 * @return
	 */
	List<LinkEn> findAll();
}
