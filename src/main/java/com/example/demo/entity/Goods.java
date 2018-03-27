package com.example.demo.entity;

/**
 * @author li
 * @create 2018-03-27 15:56
 * @desc 封装中英文
 **/
public class Goods {
    /**
     * 商品id
     */
    private  Long  goodsId;
    /**
     * 商品名称
     */
    private  String  goodsName;

    /**
     * 商品简介
     */
    private  String  goodsInfo;

    /**
     * 商品详情
     */
    private  String  goodsInfoDetail;

    /**
     * 商品图片
     */
    private  String  goodsUrl;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getGoodsInfoDetail() {
        return goodsInfoDetail;
    }

    public void setGoodsInfoDetail(String goodsInfoDetail) {
        this.goodsInfoDetail = goodsInfoDetail;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }
}
