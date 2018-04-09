package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.IdeaEntity;
/**
 * 
 * @author xwj
 * @date 2018年4月8日 下午2:17:28
 * @desc 品牌理念
 */
public interface IdeaRepository extends JpaRepository<IdeaEntity, Long>{

	@Query("select id, nameEn, contextEn from IdeaEntity where 1 = 1")
	List<Object[]> findAllByZh();

}
