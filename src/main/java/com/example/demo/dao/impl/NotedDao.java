package com.example.demo.dao.impl;

import com.example.demo.dao.INoteDao;
import com.example.demo.entity.PolicyEntity;
import com.example.demo.entity.notepadEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:18
 * @desc dis
 **/
@Repository
public class NotedDao implements INoteDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<notepadEntity> findByCompanyName(String hql) {
        TypedQuery<notepadEntity> query = this.entityManager.createQuery(hql,notepadEntity.class);

        List<notepadEntity> list=query.getResultList();

        return list;
    }

    @Override
    public List<notepadEntity> findByUserKey(String userKey) {
        TypedQuery<notepadEntity> query = this.entityManager.createQuery(" from notepadEntity u where u.userKey=:userKey ",notepadEntity.class);
        query.setParameter("userKey",userKey);
        List<notepadEntity> list=query.getResultList();

        return list;
    }

    @Override
    public List<notepadEntity> findByShare() {
        TypedQuery<notepadEntity> query = this.entityManager.createQuery("from notepadEntity u where u.share='是' ",notepadEntity.class);

        List<notepadEntity> list=query.getResultList();

        return list;
    }
}

