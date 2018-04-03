package com.example.demo.dao;

import com.example.demo.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IChatRepository extends JpaRepository<ChatEntity, Long> {

    @Query(" from  ChatEntity where sessionId=?1 order by chatDate asc")
    List<ChatEntity> findBySessionId(Long sessionId);
    @Query(" delete from  ChatEntity where sessionId=?1 ")
    void deleteBySessionId(String sessionId);
}