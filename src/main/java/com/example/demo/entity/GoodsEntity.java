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
     * 商品详情 中文
     */
    private  String  goodsInfoDetailChinese;
    /**
     * 商品详情 英文
     */
    private  String  goodsInfoDetailEnglish;
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
    @Column(name = "goods_info_detail_chinese")
    public String getGoodsInfoDetailChinese() {
        return goodsInfoDetailChinese;
    }

    public void setGoodsInfoDetailChinese(String goodsInfoDetailChinese) {
        this.goodsInfoDetailChinese = goodsInfoDetailChinese;
    }
    @Basic
    @Column(name = "goods_info_detail_English")
    public String getGoodsInfoDetailEnglish() {
        return goodsInfoDetailEnglish;
    }

    public void setGoodsInfoDetailEnglish(String goodsInfoDetailEnglish) {
        this.goodsInfoDetailEnglish = goodsInfoDetailEnglish;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsEntity that = (GoodsEntity) o;
        return Objects.equals(goodsId, that.goodsId) &&
                Objects.equals(goodsNameChinese, that.goodsNameChinese) &&
                Objects.equals(goodsNameEnglish, that.goodsNameEnglish) &&
                Objects.equals(goodsInfoChinese, that.goodsInfoChinese) &&
                Objects.equals(goodsInfoEnglish, that.goodsInfoEnglish) &&
                Objects.equals(goodsInfoDetailChinese, that.goodsInfoDetailChinese) &&
                Objects.equals(goodsInfoDetailEnglish, that.goodsInfoDetailEnglish) &&
                Objects.equals(goodsUrlChinese, that.goodsUrlChinese) &&
                Objects.equals(goodsUrlEnglish, that.goodsUrlEnglish) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goodsId, goodsNameChinese, goodsNameEnglish, goodsInfoChinese, goodsInfoEnglish, goodsInfoDetailChinese, goodsInfoDetailEnglish, goodsUrlChinese, goodsUrlEnglish, categoryId, sort);
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goodsId=" + goodsId +
                ", goodsNameChinese='" + goodsNameChinese + '\'' +
                ", goodsNameEnglish='" + goodsNameEnglish + '\'' +
                ", goodsInfoChinese='" + goodsInfoChinese + '\'' +
                ", goodsInfoEnglish='" + goodsInfoEnglish + '\'' +
                ", goodsInfoDetailChinese='" + goodsInfoDetailChinese + '\'' +
                ", goodsInfoDetailEnglish='" + goodsInfoDetailEnglish + '\'' +
                ", goodsUrlChinese='" + goodsUrlChinese + '\'' +
                ", goodsUrlEnglish='" + goodsUrlEnglish + '\'' +
                ", categoryId=" + categoryId +
                ", sort=" + sort +
                '}';
    }
}
