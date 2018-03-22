package com.example.demo.dao.impl;

import com.example.demo.dao.IGoodDao;
import com.example.demo.dao.IUserinfoDao;
import com.example.demo.entity.GoodEntity;
import com.example.demo.entity.PolicyEntity;
import com.example.demo.entity.UserinfoEntity;
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
public class GoodDao implements IGoodDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GoodEntity> selectBySecondId(Long second_id) {
        TypedQuery<GoodEntity> query = this.entityManager.createQuery("  from  GoodEntity u where u.second_id=:second_id  ",GoodEntity.class);
        query.setParameter("second_id",second_id);
        List<GoodEntity>  list =query.getResultList();
        return list;
    }
}
