package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IBedService;
import com.example.demo.dao.IBedDao;
import com.example.demo.entity.BedEn;

@Service
public class BedServiceImpl implements IBedService{
	
	@Autowired
	private IBedDao bedDao;

	@Override
	public List<BedEn> findAll() {
		// TODO Auto-generated method stub
		return bedDao.findAll();
	}

	@Override
	public List<BedEn> findById(Long id) {
		// TODO Auto-generated method stub
		return bedDao.findById(id);
	}

}
