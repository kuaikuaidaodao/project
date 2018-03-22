package com.example.demo.dao.impl;

import com.example.demo.dao.ICityinfoDao;

import com.example.demo.entity.cityinfoEntity;
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
public class CityinfoDao implements ICityinfoDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object getType() {
        Query query= this.entityManager.createNativeQuery("select DISTINCT (classify ) from cityinfo ");
        Object object= query.getResultList();
        return object;
    }

    @Override
    public List<cityinfoEntity> getInfoByType(String classify) {
        TypedQuery<cityinfoEntity> query = this.entityManager.createQuery(" from  cityinfoEntity u where u.classify=:classify  ",cityinfoEntity.class);
        query.setParameter("classify",classify);
        List<cityinfoEntity> list=query.getResultList();
        return list;
    }

    @Override
    public List<cityinfoEntity> findCheck() {
        TypedQuery<cityinfoEntity> query = this.entityManager.createQuery(" from  cityinfoEntity u where u.checked='是'  ",cityinfoEntity.class);
        List<cityinfoEntity> list=query.getResultList();
        return list;
    }
    @Override
    public List<cityinfoEntity> findNoCheck() {
        TypedQuery<cityinfoEntity> query = this.entityManager.createQuery(" from  cityinfoEntity u where u.checked='否' ",cityinfoEntity.class);
        List<cityinfoEntity> list=query.getResultList();
        return list;
    }
}

