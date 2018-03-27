package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FileEntity;

/**
 * @author xwj
 * @date 2018年3月27日 下午3:55:01
 * @desc 文件管理
 */
public interface IFileRepository extends JpaRepository<FileEntity, Long>{

	@Query("select id,fileEnName,fileEnUrl,imgUrl from FileEntity where 1=1")
	List<Object[]> findAllByZh();

	@Query("select id,fileEnName,fileEnUrl,imgUrl from FileEntity where id=?")
	List<Object[]> findOneByZh(Long id);

}
