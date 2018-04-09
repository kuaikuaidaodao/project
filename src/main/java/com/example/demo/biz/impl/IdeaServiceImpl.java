package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IdeaService;
import com.example.demo.dao.IIdeaDao;
import com.example.demo.entity.IdeaEn;

@Service
public class IdeaServiceImpl implements IdeaService{
	@Autowired
	private IIdeaDao ideaDao;

	@Override
	public List<IdeaEn> findAll() {
		// TODO Auto-generated method stub
		return ideaDao.findAll();
	}

}
