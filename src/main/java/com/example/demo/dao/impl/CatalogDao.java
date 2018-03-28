package com.example.demo.dao.impl;

import com.example.demo.dao.ICatalogDao;
import com.example.demo.entity.Menu;
import com.example.demo.entity.MenuEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public List<MenuEntity> findAllByEnglish() {
        TypedQuery<MenuEntity> query = (TypedQuery<MenuEntity>) entityManager.createNativeQuery("select menu_id,menu_name_english from Menu where parent=0 order by short");
        List<MenuEntity> list=query.getResultList();
        return list;
    }

    @Override
    public List<Menu> findAllByChinese() {
        Query query = this.entityManager.createNativeQuery("select menu_id,menu_name_chinese from Menu where parent_id=0 order by sort");
        List<Menu> list= (List<Menu>) query.getHints();
        return list;
    }
}
