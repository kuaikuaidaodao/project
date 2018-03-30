package com.example.demo.dao.impl;

import com.example.demo.dao.ICatalogRepository;
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
    ICatalogRepository iCatalogRepository;

    @Override
    public List<Object[]> findGoodsEnglish(Long menuId) {
//       StringBuffer sb=new StringBuffer();
//        sb.append("select  goodsId, goodsNameChinese as goodsName,goodsInfoChinese as goodsInfo,goodsInfoDetailChinese as goodsInfoDetail,goodsUrlChinese as goodsUrl from GoodsEntity where menuId=( ");
//        sb.append(menuId+",");
        while (true){
            List parentId=iCatalogRepository.findmenuId(menuId);
            if (parentId!=null){
                for (Object list: parentId){
                    System.out.println(list.toString());
                }
            }else{
                break;
            }
        }
//        sb.append("order by sort asc");

//        Query query = this.entityManager.createQuery("  from  UserinfoEntity u where u.password=:password and u.userName=:userName ");
//        List<UserinfoEntity>  list =query.getResultList();
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
