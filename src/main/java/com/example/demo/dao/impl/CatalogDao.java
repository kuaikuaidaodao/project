package com.example.demo.dao.impl;

import com.example.demo.dao.ICatalogDao;
import com.example.demo.dao.IUserinfoDao;
import com.example.demo.entity.SecondlevelEntity;
import com.example.demo.entity.UserinfoEntity;
import com.example.demo.entity.cityinfoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:15
 * @desc 用户
 **/
@Repository
public class CatalogDao implements ICatalogDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SecondlevelEntity> findByFirstId(Long firstId) {
        TypedQuery<SecondlevelEntity> query = this.entityManager.createQuery(" from  SecondlevelEntity u where u.firstId=:firstId  ",SecondlevelEntity.class);
        query.setParameter("firstId",firstId);
        List<SecondlevelEntity> list=query.getResultList();
        return list;
    }
}
