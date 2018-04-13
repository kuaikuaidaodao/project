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
    public List findGoodsEnglish(Long categoryId) {
        List<Object[]> list=iGoodRepository.findGoodsEnglish(categoryId);
        return this.cast(list);
    }

    @Override
    public List findGoodsChinese(Long categoryId) {
        List<Object[]> list=iGoodRepository.findGoodsChinese(categoryId);
        return this.cast(list);
    }

    @Override
    public Goods findGoodsByIdEnglish(Long goodsId) {
        Object[] obj= (Object[]) iGoodRepository.findGoodsByIdEnglish(goodsId);
        Goods goods=new Goods();
        if (obj!=null){
            if (null != obj[0]) {
                goods.setGoodsName(obj[0].toString());
            }
            if (null != obj[1]) {
                goods.setGoodsInfo(obj[1].toString());
            }
            if (null != obj[2]) {
                goods.setGoodsModel(obj[2].toString());
            }
            if (null != obj[3]) {
                goods.setGoodsBrand(obj[3].toString());
            }
            if (null != obj[4]) {
                goods.setGoodsNumber(obj[4].toString());
            }
            if (null != obj[5]) {
                goods.setGoodsBulk(obj[5].toString());
            }
            if (null != obj[6]) {
                goods.setGoodsWeight(obj[6].toString());
            }
            if (null != obj[7]) {
                goods.setGoodsUrl(obj[7].toString());
            }
            goods.setGoodsId(goodsId);
        }
        return goods;
    }

    @Override
    public Goods findGoodsByIdChinese(Long goodsId) {
        Object[] obj= (Object[]) iGoodRepository.findGoodsByIdChinese(goodsId);
        Goods goods=new Goods();
        if (obj!=null){
            if (null != obj[0]) {
                goods.setGoodsName(obj[0].toString());
            }
            if (null != obj[1]) {
                goods.setGoodsInfo(obj[1].toString());
            }
            if (null != obj[2]) {
                goods.setGoodsModel(obj[2].toString());
            }
            if (null != obj[3]) {
                goods.setGoodsBrand(obj[3].toString());
            }
            if (null != obj[4]) {
                goods.setGoodsNumber(obj[4].toString());
            }
            if (null != obj[5]) {
                goods.setGoodsBulk(obj[5].toString());
            }
            if (null != obj[6]) {
                goods.setGoodsWeight(obj[6].toString());
            }
            if (null != obj[7]) {
                goods.setGoodsUrl(obj[7].toString());
            }
            goods.setGoodsId(goodsId);
        }
        return goods;
    }

    @Override
    public List findByCategoryId(String s) {
        return iGoodsDao.findByCategoryId(s);
    }

    @Override
    public List findAll(int page) {
        return iGoodsDao.findAll(page);
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
                goods.setGoodsModel(obj[3].toString());
            }
            if (null != obj[4]) {
                goods.setGoodsBrand(obj[4].toString());
            }
            if (null != obj[5]) {
                goods.setGoodsNumber(obj[5].toString());
            }
            if (null != obj[6]) {
                goods.setGoodsBulk(obj[6].toString());
            }
            if (null != obj[7]) {
                goods.setGoodsWeight(obj[7].toString());
            }
            if (null != obj[8]) {
                goods.setGoodsUrl(obj[8].toString());
            }
            good.add(goods);
        }
        return good;
    }
}
