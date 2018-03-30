package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ManPowerEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午4:56:33
 * @desc 人力资源
 */
public interface IManPowerRepository extends JpaRepository<ManPowerEntity, Long>{

	@Query("select id, nameEn, sort from ManPowerEntity where 1 = 1 order by sort asc")
	List<Object[]> findAllByZh();

}
