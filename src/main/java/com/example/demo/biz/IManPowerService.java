package com.example.demo.biz;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.ManPowerEn;
import com.example.demo.entity.ManPowerEntity;

public interface IManPowerService {

	List<ManPowerEn> findAll();
	Page<ManPowerEntity> findBookNoCriteria(Integer page,Integer size);
}
