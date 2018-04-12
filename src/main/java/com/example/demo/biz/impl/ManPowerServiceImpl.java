package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IManPowerService;
import com.example.demo.dao.IManPowerDao;
import com.example.demo.dao.IManPowerRepository;
import com.example.demo.entity.ManPowerEn;
import com.example.demo.entity.ManPowerEntity;

@Service
public class ManPowerServiceImpl implements IManPowerService{
	@Autowired
	private IManPowerDao manPowerDao;

	@Autowired
	private IManPowerRepository manPowerRepository;
	@Override
	public List<ManPowerEn> findAll() {
		// TODO Auto-generated method stub
		return manPowerDao.findAll();
	}
	
	@Override
	public org.springframework.data.domain.Page<ManPowerEntity> findBookNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		return manPowerRepository.findAll(pageable);
	}
}
