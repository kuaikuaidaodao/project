package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IBrandService;
import com.example.demo.dao.IBrandDao;
import com.example.demo.entity.BrandEn;
@Service
public class BrandServiceImpl implements IBrandService{

	@Autowired
	private IBrandDao brandDao;
	@Override
	public List<BrandEn> findAll() {
		// TODO Auto-generated method stub
		return brandDao.findAll();
	}

}
