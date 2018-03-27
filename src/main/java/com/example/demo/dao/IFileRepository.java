package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FileEntity;

public interface IFileRepository extends JpaRepository<FileEntity, Long>{

	@Query("select id,fileEnName,fileUrl,imgUrl from FileEntity where 1=1")
	List<Object[]> findAllByZh();

}
