package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

public interface IFileService {

	FileEn findById(Long id);

	List<FileEn> findAll();
}
