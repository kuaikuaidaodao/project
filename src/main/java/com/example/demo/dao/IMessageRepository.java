package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MessagesEntity;
@Repository
public interface IMessageRepository extends JpaRepository<MessagesEntity, Long>{

	@Query("from MessagesEntity where 1 =1 order by type asc,time desc")
	List<MessagesEntity> findAllByType();
}
