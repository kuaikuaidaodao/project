package com.example.demo.dao.impl;

import com.example.demo.dao.IGoodsDao;
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
public class GoodsDao implements IGoodsDao {
    @PersistenceContext
    private EntityManager entityManager;
}
