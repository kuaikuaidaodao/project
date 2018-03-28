package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Banner;

/**
 * @author xwj
 * @date 2018年3月27日 下午3:53:49
 * @desc banner图
 */
public interface IBannerRepository extends JpaRepository<Banner, Long> {

	/**
	 * 查询banner图
	 * @return
	 */
	@Query("select id,goodid,goodName,imgEnUrl,time from Banner")
	List<Object[]> findAllByZh();

}
