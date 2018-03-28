package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.CompanyEn;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午11:12:07
 * @desc 公司详情
 */
public interface ICompanyDao {
 
	/**
	 * 查询所有
	 * @return
	 */
	List<CompanyEn> findAll();
}
