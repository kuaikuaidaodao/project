package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IBannerService;
import com.example.demo.dao.IBannerDao;
import com.example.demo.entity.BannerEn;
/**
 * 
 * @author xwj
 * @date 2018年3月27日 下午3:51:54
 * @description 轮播图
 */
@Service
public class BannerServiceImpl implements IBannerService{
	@Autowired
	IBannerDao bannerDao;

	@Override
	public List<BannerEn> findAll() {
		// TODO Auto-generated method stub
		return bannerDao.findAll();
	}

}
