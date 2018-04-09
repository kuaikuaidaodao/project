package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FactoryEntity;

public interface IFactoryRepository extends JpaRepository<FactoryEntity, Long>{

	@Query("select id, nameEn, contextEn, imageUrl, sort from FactoryEntity where 1 = 1 order by sort desc")
	List<Object[]> findAllByZh();

}
