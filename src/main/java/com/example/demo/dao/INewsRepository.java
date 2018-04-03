package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.NewsEntity;
/**
 * 
 * @author xwj
 * @date 2018年4月3日 上午10:06:52
 * @desc 新闻
 */
public interface INewsRepository extends JpaRepository<NewsEntity, Long>{

	@Query("select id,nameEn,contextEn,imgurl,writerEn,resourceEn,time,type from NewsEntity where type=?")
	List<Object[]> findAllByZh(Long type);

	@Query("select id,nameEn,contextEn,imgurl,writerEn,resourceEn,time,type from NewsEntity where id=?")
	List<Object[]> findOneByZh(Long id);

	@Query("select id,name,nameEn,context,contextEn,imgurl,writer,writerEn,resource,resourceEn,time,type from NewsEntity where type=? order by time asc")
	List findAllByType(Long type);

}
