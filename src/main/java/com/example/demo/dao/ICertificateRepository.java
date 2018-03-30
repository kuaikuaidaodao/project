package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CertificateEntity;

public interface ICertificateRepository extends JpaRepository<CertificateEntity, Long>{

	//查询英文版内容
	@Query("select id, imageUrls, contextEn from CertificateEntity where 1 = 1")
	List<Object[]> findAllByZh();

}
