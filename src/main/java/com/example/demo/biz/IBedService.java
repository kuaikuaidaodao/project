package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.BedEn;

public interface IBedService {

	List<BedEn> findAll();

	List<BedEn> findById(Long id);
}
