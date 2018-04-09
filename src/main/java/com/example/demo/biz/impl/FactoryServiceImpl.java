package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IFactoryService;
import com.example.demo.dao.IFactoryDao;
import com.example.demo.entity.FactoryEn;

@Service
public class FactoryServiceImpl implements IFactoryService{

	@Autowired
	private IFactoryDao factoryDao;
	@Override
	public List<FactoryEn> findAll() {
		// TODO Auto-generated method stub
		return factoryDao.findAll();
	}

}
