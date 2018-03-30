package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.BedEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午3:29:33
 * @desc 游戏床
 */
public interface IBedRepository extends JpaRepository<BedEntity, Long>{

	@Query("select id, bedId,reqmaterialsEn,optmaterialsEn,toolEn,conditionEn,limitEn,problemEn from BedEntity where 1=1")
	List<Object[]> findAllByZh();
	
	@Query("select id, bedId,reqmaterialsEn,optmaterialsEn,toolEn,conditionEn,limitEn,problemEn from BedEntity where id=?")
	List<Object[]> findOneByZh(Long id);

}
