package com.example.demo.dao.impl;

import com.example.demo.dao.ICatalogRepository;
import com.example.demo.dao.ICategoryRepository;
import com.example.demo.dao.IGoodsDao;
import com.example.demo.entity.GoodsEntity;
import com.example.demo.entity.MenuEntity;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GoodsDao implements IGoodsDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Object[]> findGoodsEnglish(Long menuId) {
//       StringBuffer sb=new StringBuffer();
//        sb.append("select  goodsId, goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsInfoDetailChinese as goodsInfoDetail,goodsUrlChinese as goodsUrl from GoodsEntity where menuId=( ");
//        sb.append(menuId+",");
        while (true){
            List parentId=iCategoryRepository.findCategoryId(menuId);
            if (parentId!=null){
                for (Object list: parentId){
                    System.out.println(list.toString());
                }
            }else{
                break;
            }
        }
        return null;
    }

    @Override
    public List findByCategoryId(String s) {
               StringBuffer sb=new StringBuffer();
        sb.append(" from GoodsEntity where categoryId  in ");
        sb.append(s);
        sb.append(" order by sort ");
        TypedQuery<GoodsEntity> query =  entityManager.createQuery(sb.toString(), GoodsEntity.class);
        List<GoodsEntity> list=query.getResultList();
        return list;
    }
}
