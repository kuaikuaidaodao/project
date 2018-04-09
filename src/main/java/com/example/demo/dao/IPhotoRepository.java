package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.PhotoEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月8日 上午9:24:57
 * @desc 画册
 */
public interface IPhotoRepository extends JpaRepository<PhotoEntity, Long>{

	@Query("select id, nameEn, imageUrl,sort from PhotoEntity where 1 = 1 order by sort desc")
	List<Object[]> findAllByZh();

}
