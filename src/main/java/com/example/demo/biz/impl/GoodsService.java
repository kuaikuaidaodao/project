package com.example.demo.biz.impl;

import com.example.demo.biz.IGoodsService;
import com.example.demo.dao.IGoodsDao;
import com.example.demo.dao.IGoodsRepository;
import com.example.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
@Service
public class GoodsService implements IGoodsService {
    @Autowired
    IGoodsDao iGoodsDao;
    @Autowired
    IGoodsRepository iGoodRepository;



    @Override
    public List findGoodsEnglish(Long menuId) {
        List<Object[]> list=iGoodRepository.findGoodsEnglish(menuId);
        return this.cast(list);
    }

    @Override
    public List findGoodsChinese(Long menuId) {
        List<Object[]> list=iGoodRepository.findGoodsChinese(menuId);
        return this.cast(list);
    }

    @Override
    public Goods findGoodsByIdEnglish(Long goodsId) {
        Object[] obj=iGoodRepository.findGoodsByIdEnglish(goodsId);
        Goods goods=new Goods();
        if (obj!=null){
            if (null != obj[0]) {
                goods.setGoodsName(obj[0].toString());
            }
            if (null != obj[1]) {
                goods.setGoodsInfo(obj[1].toString());
            }
            if (null != obj[2]) {
                goods.setGoodsInfoDetail(obj[2].toString());
            }
            if (null != obj[3]) {
                goods.setGoodsUrl(obj[3].toString());
            }
        }
        return goods;
    }

    @Override
    public Goods findGoodsByIdChinese(Long goodsId) {
        Object[] obj=iGoodRepository.findGoodsByIdChinese(goodsId);
        Goods goods=new Goods();
        if (obj!=null){
            if (null != obj[0]) {
                goods.setGoodsName(obj[0].toString());
            }
            if (null != obj[1]) {
                goods.setGoodsInfo(obj[1].toString());
            }
            if (null != obj[2]) {
                goods.setGoodsInfoDetail(obj[2].toString());
            }
            if (null != obj[3]) {
                goods.setGoodsUrl(obj[3].toString());
            }
        }
        return goods;
    }

    private List<Goods> cast(List<Object[]> list){
        List<Goods> good=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            Goods goods=new Goods();
            Object[] obj=list.get(i);
            if (null != obj[0]) {
                goods.setGoodsId(Long.valueOf(obj[0].toString()));
            }
            if (null != obj[1]) {
                goods.setGoodsName(obj[1].toString());
            }
            if (null != obj[2]) {
                goods.setGoodsInfo(obj[2].toString());
            }
            if (null != obj[3]) {
                goods.setGoodsInfoDetail(obj[3].toString());
            }
            if (null != obj[4]) {
                goods.setGoodsUrl(obj[4].toString());
            }
            good.add(goods);
        }
        return good;
    }
}
