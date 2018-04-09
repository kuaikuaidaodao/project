package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IPhotoDao;
import com.example.demo.dao.IPhotoRepository;
import com.example.demo.entity.PhotoEn;

@Repository
public class PhotoDao implements IPhotoDao{
	
	@Autowired
	private IPhotoRepository photoRepository;

	@Override
	public List<PhotoEn> findAll() {
		List<Object[]> list = photoRepository.findAllByZh();
		List<PhotoEn> pbotoEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			PhotoEn pbotoEn = new PhotoEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				pbotoEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				pbotoEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				pbotoEn.setImageUrl(obj[2].toString());
			}
			if (obj[3] != null) {
				pbotoEn.setSort(Long.valueOf(obj[3].toString()));
			}
			pbotoEns.add(pbotoEn);
		}
		return pbotoEns;
	}

}
