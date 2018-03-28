package com.example.demo.dao;

import com.example.demo.entity.ChatEntity;
import com.example.demo.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IChatRepository extends JpaRepository<ChatEntity, Long> {

    @Query(" from  GoodsEntity where sessionId=?1 order by chatData asc")
    List<ChatEntity> findBySessionId(Long sessionId);
    @Query(" delete from  GoodsEntity where sessionId=?1 ")
    void deleteBySessionId(String sessionId);
}