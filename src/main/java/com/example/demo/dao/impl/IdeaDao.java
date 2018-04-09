package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IIdeaDao;
import com.example.demo.dao.IdeaRepository;
import com.example.demo.entity.IdeaEn;

@Repository
public class IdeaDao implements IIdeaDao{
	
	@Autowired
	private IdeaRepository ideaRepository;

	@Override
	public List<IdeaEn> findAll() {
		List<Object[]> list = ideaRepository.findAllByZh();
		List<IdeaEn> ideaEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			IdeaEn ideaEn = new IdeaEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				ideaEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				ideaEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				ideaEn.setContext(obj[2].toString());
			}
			ideaEns.add(ideaEn);
		}
		return ideaEns;
	}

}
