package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.biz.ICompanyService;
import com.example.demo.dao.ICompanyDao;
import com.example.demo.entity.CompanyEn;
/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午11:30:28
 * @desc 公司详情
 */
@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	ICompanyDao companyDao;
	@Override
	public List<CompanyEn> findAll() {
		// TODO Auto-generated method stub
		return companyDao.findAll();
	}

	
}
