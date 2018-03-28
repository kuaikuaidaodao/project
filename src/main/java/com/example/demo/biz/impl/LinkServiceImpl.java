package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.biz.ILinkService;
import com.example.demo.dao.ILinkDao;
import com.example.demo.entity.LinkEn;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午10:17:09
 * @desc 友情链接
 */
@Service
public class LinkServiceImpl implements ILinkService{
	@Autowired
	ILinkDao linkDao;

	@Override
	public List<LinkEn> findAll() {
		// TODO Auto-generated method stub
		return linkDao.findAll();
	}

}
