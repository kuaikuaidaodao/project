package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BrandEntity;
@Repository
public interface IBrandRepository extends JpaRepository<BrandEntity, Long>{

	@Query("select id, nameEn, url, imageUrl, sort from BrandEntity where 1 = 1 order by sort desc")
	List<Object[]> findAllByZh();

}
