package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.LinkEn;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午9:52:29
 * @desc 友情链接
 */
public interface ILinkService {

	/**
	 * 查询英文版名字
	 * 
	 * @return
	 */
	List<LinkEn> findAll();
}
