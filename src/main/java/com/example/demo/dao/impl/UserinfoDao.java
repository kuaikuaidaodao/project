package com.example.demo.dao.impl;

import com.example.demo.dao.IUserinfoDao;
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
public class UserinfoDao implements IUserinfoDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<UserinfoEntity> selectByNameAndPassword(String userName, String password) {
        TypedQuery<UserinfoEntity> query = this.entityManager.createQuery("  from  UserinfoEntity u where u.password=:password and u.userName=:userName  ",UserinfoEntity.class);
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        List<UserinfoEntity>  list =query.getResultList();
        return list;
    }
}
