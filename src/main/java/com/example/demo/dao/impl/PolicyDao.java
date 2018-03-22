package com.example.demo.dao.impl;

import com.example.demo.dao.IPolicyDao;
import com.example.demo.entity.PolicyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:18
 * @desc dis
 **/
@Repository
public class PolicyDao implements IPolicyDao {
    @PersistenceContext
    private EntityManager entityManager;
    public    List<PolicyEntity>  getPolicyByClassify(String classify) {
        TypedQuery<PolicyEntity> query = this.entityManager.createQuery("  from  PolicyEntity u where u.classify=:classify  ",PolicyEntity.class);
        query.setParameter("classify",classify);
        System.out.println(classify+"数据库查询--------------------");
        List<PolicyEntity>  list =query.getResultList();
        return list;
    }

    @Override
    public List<PolicyEntity> selectByim(String hql, String startDate, String endDate, String organization) {
        TypedQuery<PolicyEntity> query = this.entityManager.createQuery(hql,PolicyEntity.class);
//        if (null!=startDate&&!"".equals(startDate)) {
//            query.setParameter("startDate",startDate);
//        }
//        if (null!=endDate&&!"".equals(endDate)) {
//            query.setParameter("endDate",endDate);
//        }
        if (null!=organization&&!"".equals(organization)) {
            System.out.println("进来了----");
            query.setParameter("organization",organization);

        }
        List<PolicyEntity> list=query.getResultList();

        return list;
    }
}

