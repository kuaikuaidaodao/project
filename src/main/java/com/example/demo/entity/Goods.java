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
     * 商品图片
     */
    private  String  goodsUrl;
    /**
     * 商品型号
     */
    private  String  goodsModel;

    /**
     * 商品品牌
     */
    private  String  goodsBrand;
    /**
     * 包装数量
     */
    private  String  goodsNumber;

    /**
     * 包装体积
     */
    private  String  goodsBulk;

    /**
     * 包装重量
     */
    private  String  goodsWeight;


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

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsBulk() {
        return goodsBulk;
    }

    public void setGoodsBulk(String goodsBulk) {
        this.goodsBulk = goodsBulk;
    }

    public String getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }
}
