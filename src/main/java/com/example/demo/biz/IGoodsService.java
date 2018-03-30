package com.example.demo.biz;

import com.example.demo.entity.Goods;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
public interface IGoodsService {

// 查询商品  英文
    List findGoodsEnglish(Long menuId);
    // 查询商品  中文
    List findGoodsChinese(Long menuId);
    // 查询单个商品详情  英文
    Goods findGoodsByIdEnglish(Long goodsId);
    // 查询单个商品详情  中文
    Goods findGoodsByIdChinese(Long goodsId);

    List findByCategoryId(String s);
}
