package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IManPowerDao;
import com.example.demo.dao.IManPowerRepository;
import com.example.demo.entity.BannerEn;
import com.example.demo.entity.ManPowerEn;

@Repository
public class ManPowerDao implements IManPowerDao{
	@Autowired
	private IManPowerRepository manPowerRepository;

	@Override
	public List<ManPowerEn> findAll() {
		List<Object[]> list = manPowerRepository.findAllByZh();
		List<ManPowerEn> manPower = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ManPowerEn manPowerEn = new ManPowerEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				manPowerEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				manPowerEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				manPowerEn.setSort(Integer.valueOf(obj[2].toString()));
			}
			
			manPower.add(manPowerEn);
		}
		return manPower;
	}

}
