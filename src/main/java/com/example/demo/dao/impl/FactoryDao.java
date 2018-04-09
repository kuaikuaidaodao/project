package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IFactoryDao;
import com.example.demo.dao.IFactoryRepository;
import com.example.demo.entity.BannerEn;
import com.example.demo.entity.FactoryEn;
@Repository
public class FactoryDao implements IFactoryDao{
	
	@Autowired
	private IFactoryRepository factoryRepository;

	@Override
	public List<FactoryEn> findAll() {
		List<Object[]> list = factoryRepository.findAllByZh();
		List<FactoryEn> factoryEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			FactoryEn factoryEn = new FactoryEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				factoryEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				factoryEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				factoryEn.setContext(obj[2].toString());
			}
			if (obj[3] != null) {
				factoryEn.setIamgeUrl(obj[3].toString());
			}
			if (obj[4] != null) {
				factoryEn.setSort(Long.valueOf(obj[4].toString()));
			}
			factoryEns.add(factoryEn);
		}
		return factoryEns;
	}

}
