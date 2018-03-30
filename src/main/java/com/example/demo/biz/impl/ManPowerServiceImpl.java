package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IManPowerService;
import com.example.demo.dao.IManPowerDao;
import com.example.demo.entity.ManPowerEn;

@Service
public class ManPowerServiceImpl implements IManPowerService{
	@Autowired
	private IManPowerDao manPowerDao;

	@Override
	public List<ManPowerEn> findAll() {
		// TODO Auto-generated method stub
		return manPowerDao.findAll();
	}

}
