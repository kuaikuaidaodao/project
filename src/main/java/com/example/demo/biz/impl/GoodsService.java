package com.example.demo.biz.impl;

import com.example.demo.biz.IGoodsService;
import com.example.demo.dao.IGoodsDao;
import com.example.demo.dao.IGoodRepository;
import com.example.demo.entity.GoodEntity;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Menu;
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
    IGoodRepository iGoodRepository;

    @Override
    public List<GoodEntity> selectBySecondId(Long second_id) {
        return iGoodsDao.selectBySecondId(second_id);
    }

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
