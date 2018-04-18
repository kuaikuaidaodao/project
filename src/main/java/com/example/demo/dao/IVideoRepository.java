package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VideoEntity;

@Repository
public interface IVideoRepository extends JpaRepository<VideoEntity, Long>{

	@Query("select id, nameEn, videoUrl,sort from VideoEntity where 1 = 1 order by sort desc")
	List<Object[]> findAllByZh();
}
