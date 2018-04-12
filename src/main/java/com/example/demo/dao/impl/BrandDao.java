package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IBrandDao;
import com.example.demo.dao.IBrandRepository;
import com.example.demo.entity.BrandEn;
@Repository
public class BrandDao implements IBrandDao{

	@Autowired
	private IBrandRepository brandRepository;
	@Override
	public List<BrandEn> findAll() {
		List<Object[]> list = brandRepository.findAllByZh();
		List<BrandEn> brandEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			BrandEn brandEn = new BrandEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				brandEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				brandEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				brandEn.setUrl(obj[2].toString());
			}
			if (obj[3] != null) {
				brandEn.setImageUrl(obj[3].toString());
			}
			if (obj[4] != null) {
				brandEn.setSort(Long.valueOf(obj[4].toString()));
			}
			brandEns.add(brandEn);
		}
		return brandEns;
	}

}
