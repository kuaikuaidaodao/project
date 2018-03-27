package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

public interface IFileDao {

	FileEn findById(Long id);
	
	List<FileEn> findAll();
}
