package com.example.demo.dao;

import com.example.demo.entity.ChatEntity;
import org.hibernate.annotations.OnDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IChatRepository extends JpaRepository<ChatEntity, Long> {

    @Query(" from  ChatEntity where sessionId=?1 order by chatDate asc")
    List<ChatEntity> findBySessionId(String sessionId);

    @Modifying
    @Transactional
    @Query(" delete from  ChatEntity where sessionId=?1 ")
    void deleteBySessionId(String sessionId);

    @Query(" select count(distinct sessionId) from  ChatEntity  ")
    int lx();

//    @Query(" select distinct (sessionId) from  ChatEntity  ")
//    List<String> findBySessionId();
    @Query(" select distinct (sessionId),chatName from  ChatEntity ORDER BY chatDate ")
    List<Object[]> findSessionIdAndChatName();
}