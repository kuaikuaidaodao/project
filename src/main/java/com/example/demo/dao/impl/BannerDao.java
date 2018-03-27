package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IBannerDao;
import com.example.demo.dao.IBannerRepository;
import com.example.demo.entity.BannerEn;

/**
 * 
 * @author xwj
 * @date 2018年3月27日 下午3:55:28
 * @desc banner图
 */
@Repository
public class BannerDao implements IBannerDao{
	
	@Autowired
	private IBannerRepository bannerRepository;

	/**
	 * 查询所有区分中英文
	 */
	@Override
	public List<BannerEn> findAll() {
		List<Object[]> list = bannerRepository.findAllByZh();
		List<BannerEn> bannerEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			BannerEn bannerEn = new BannerEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				bannerEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				bannerEn.setGoodid(obj[1].toString());
			}
			if (obj[2] != null) {
				bannerEn.setGoodName(obj[2].toString());
			}
			if (obj[3] != null) {
				bannerEn.setImgurl(obj[3].toString());
			}
			bannerEn.setTime(new Date());
			
			bannerEns.add(bannerEn);
		}
		return bannerEns;
	}
}
