package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IBedDao;
import com.example.demo.dao.IBedRepository;
import com.example.demo.entity.BedEn;
import com.example.demo.entity.FileEn;

@Repository
public class BedDao implements IBedDao{
	
	@Autowired
	private IBedRepository bedRepository;

	@Override
	public List<BedEn> findAll() {
		List<Object[]> list = bedRepository.findAllByZh();
		List<BedEn> bedEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			BedEn bedEn = new BedEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				bedEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				bedEn.setBedId(Long.valueOf(obj[1].toString()));
			}
			if (obj[2] != null) {
				bedEn.setReqmaterials(obj[2].toString());
			}
			if (obj[3] != null) {
				bedEn.setOptmaterials(obj[3].toString());
			}
			if (obj[4] != null) {
				bedEn.setTool(obj[4].toString());
			}
			if (obj[5] != null) {
				bedEn.setCondition(obj[5].toString());
			}
			if (obj[6] != null) {
				bedEn.setLimit(obj[6].toString());
			}
			if (obj[7] != null) {
				bedEn.setProblem(obj[7].toString());
			}
			bedEns.add(bedEn);
		}
		return bedEns;
	}

	@Override
	public List<BedEn> findById(Long id) {
		List<Object[]> list = bedRepository.findOneByZh(id);
		List<BedEn> bedEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			BedEn bedEn = new BedEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				bedEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				bedEn.setBedId(Long.valueOf(obj[1].toString()));
			}
			if (obj[2] != null) {
				bedEn.setReqmaterials(obj[2].toString());
			}
			if (obj[3] != null) {
				bedEn.setOptmaterials(obj[3].toString());
			}
			if (obj[4] != null) {
				bedEn.setTool(obj[4].toString());
			}
			if (obj[5] != null) {
				bedEn.setCondition(obj[5].toString());
			}
			if (obj[6] != null) {
				bedEn.setLimit(obj[6].toString());
			}
			if (obj[7] != null) {
				bedEn.setProblem(obj[7].toString());
			}
			bedEns.add(bedEn);

		bedEns.add(bedEn);
		}
		return bedEns;
	}

}
