package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.CompanyEn;
/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午11:26:33
 * @desc 公司详情
 */
public interface ICompanyService {

	//查询英文版公司详情
	List<CompanyEn> findAll();
}
