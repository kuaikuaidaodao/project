package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author li
 * @create 2018-03-27 14:21
 * @desc 商品
 **/
@Entity
@Table(name="goods")
public class GoodsEntity {
    /**
     * 商品id
     */
    private  Long  goodsId;
    /**
     * 商品名称  中文
     */
    private  String  goodsNameChinese;
    /**
     * 商品名称  英文
     */
    private  String  goodsNameEnglish;
    /**
     * 商品简介 中文
     */
    private  String  goodsInfoChinese;
    /**
     * 商品简介 英文
     */
    private  String  goodsInfoEnglish;
    /**
     * 商品型号 中文
     */
    private  String  goodsModelChinese;
    /**
     * 商品型号 英文
     */
    private  String  goodsModelEnglish;
    /**
     * 商品品牌 中文
     */
    private  String  goodsBrandChinese;
    /**
     * 商品品牌 英文
     */
    private  String  goodsBrandEnglish;
    /**
     * 包装数量 中文
     */
    private  String  goodsNumberChinese;
    /**
     * 包装数量 英文
     */
    private  String  goodsNumberEnglish;
    /**
     * 包装体积 中文
     */
    private  String  goodsBulkChinese;
    /**
     * 包装体积 英文
     */
    private  String  goodsBulkEnglish;
    /**
     * 包装重量 中文
     */
    private  String  goodsWeightChinese;
    /**
     * 包装重量 英文
     */
    private  String  goodsWeightEnglish;
    /**
     * 商品图片 中文
     */
    private  String  goodsUrlChinese;
    /**
     * 商品图片 英文
     */
    private  String  goodsUrlEnglish;
    /**
     * 商品 父id
     */
    private  Long  categoryId;
    /**
     * 商品排序
     */
    private  Long  sort;

    public GoodsEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "goods_Id", nullable = false, precision = 0 )
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    @Basic
    @Column(name = "goods_name_chinese")
    public String getGoodsNameChinese() {
        return goodsNameChinese;
    }

    public void setGoodsNameChinese(String goodsNameChinese) {
        this.goodsNameChinese = goodsNameChinese;
    }
    @Basic
    @Column(name = "goods_name_English")
    public String getGoodsNameEnglish() {
        return goodsNameEnglish;
    }

    public void setGoodsNameEnglish(String goodsNameEnglish) {
        this.goodsNameEnglish = goodsNameEnglish;
    }
    @Basic
    @Column(name = "goods_info_chinese")
    public String getGoodsInfoChinese() {
        return goodsInfoChinese;
    }

    public void setGoodsInfoChinese(String goodsInfoChinese) {
        this.goodsInfoChinese = goodsInfoChinese;
    }
    @Basic
    @Column(name = "goods_info_English")
    public String getGoodsInfoEnglish() {
        return goodsInfoEnglish;
    }

    public void setGoodsInfoEnglish(String goodsInfoEnglish) {
        this.goodsInfoEnglish = goodsInfoEnglish;
    }
    @Basic
    @Column(name = "goods_url_chinese")
    public String getGoodsUrlChinese() {
        return goodsUrlChinese;
    }

    public void setGoodsUrlChinese(String goodsUrlChinese) {
        this.goodsUrlChinese = goodsUrlChinese;
    }
    @Basic
    @Column(name = "goods_url_English")
    public String getGoodsUrlEnglish() {
        return goodsUrlEnglish;
    }
    public void setGoodsUrlEnglish(String goodsUrlEnglish) {
        this.goodsUrlEnglish = goodsUrlEnglish;
    }
    @Basic
    @Column(name = "category_Id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    @Basic
    @Column(name = "sort")
    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }
    @Basic
    @Column(name = "goods_model_chinese")
    public String getGoodsModelChinese() {
        return goodsModelChinese;
    }

    public void setGoodsModelChinese(String goodsModelChinese) {
        this.goodsModelChinese = goodsModelChinese;
    }
    @Basic
    @Column(name = "goods_model_english")
    public String getGoodsModelEnglish() {
        return goodsModelEnglish;
    }

    public void setGoodsModelEnglish(String goodsModelEnglish) {
        this.goodsModelEnglish = goodsModelEnglish;
    }
    @Basic
    @Column(name = "goods_brand_chinese")
    public String getGoodsBrandChinese() {
        return goodsBrandChinese;
    }

    public void setGoodsBrandChinese(String goodsBrandChinese) {
        this.goodsBrandChinese = goodsBrandChinese;
    }
    @Basic
    @Column(name = "goods_brand_english")
    public String getGoodsBrandEnglish() {
        return goodsBrandEnglish;
    }

    public void setGoodsBrandEnglish(String goodsBrandEnglish) {
        this.goodsBrandEnglish = goodsBrandEnglish;
    }
    @Basic
    @Column(name = "goods_number_chinese")
    public String getGoodsNumberChinese() {
        return goodsNumberChinese;
    }

    public void setGoodsNumberChinese(String goodsNumberChinese) {
        this.goodsNumberChinese = goodsNumberChinese;
    }
    @Basic
    @Column(name = "goods_number_english")
    public String getGoodsNumberEnglish() {
        return goodsNumberEnglish;
    }

    public void setGoodsNumberEnglish(String goodsNumberEnglish) {
        this.goodsNumberEnglish = goodsNumberEnglish;
    }
    @Basic
    @Column(name = "goods_bulk_chinese")
    public String getGoodsBulkChinese() {
        return goodsBulkChinese;
    }
    public void setGoodsBulkChinese(String goodsBulkChinese) {
        this.goodsBulkChinese = goodsBulkChinese;
    }
    @Basic
    @Column(name = "goods_bulk_english")
    public String getGoodsBulkEnglish() {
        return goodsBulkEnglish;
    }

    public void setGoodsBulkEnglish(String goodsBulkEnglish) {
        this.goodsBulkEnglish = goodsBulkEnglish;
    }
    @Basic
    @Column(name = "goods_weight_chinese")
    public String getGoodsWeightChinese() {
        return goodsWeightChinese;
    }

    public void setGoodsWeightChinese(String goodsWeightChinese) {
        this.goodsWeightChinese = goodsWeightChinese;
    }
    @Basic
    @Column(name = "goods_weight_english")
    public String getGoodsWeightEnglish() {
        return goodsWeightEnglish;
    }

    public void setGoodsWeightEnglish(String goodsWeightEnglish) {
        this.goodsWeightEnglish = goodsWeightEnglish;
    }
}
