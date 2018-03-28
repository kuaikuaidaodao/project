package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.LinkEntity;

/**
 *  
 * @author xwj
 * @date 2018年3月28日 上午10:15:41
 * @desc 友情链接
 */
public interface ILinkRepository extends JpaRepository<LinkEntity, Long>{

	/**
	 * 查询友情链接
	 * @return
	 */
	@Query("select id, url, nameEn from LinkEntity where 1 = 1")
	List<Object[]> findAllByZh();

}
