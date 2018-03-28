package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CompanyEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午11:06:22
 * @desc 公司详情
 */
public interface ICompanyRepository extends JpaRepository<CompanyEntity, Long>{

	/**
	 * 查询所有
	 * @return
	 */
	@Query("select id, nameEn, descEn, imgurlEn, addressEn, phone from CompanyEntity where 1 = 1")
    List<Object[]> findAllByZh();
}
   