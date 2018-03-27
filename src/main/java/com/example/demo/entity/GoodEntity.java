package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author li
 * @create 2018-03-21 9:34
 * @desc 级目录
 **/
@Entity
@Table(name="good")
public class GoodEntity {
    /**
     * 二级id
     */
    private  Long secondId;
    /**
     * 一商品id
     */
    private  Long goodId;
    /**
     *  商品名称
     */
    private  String goodName;

    /**
     *  商品简介
     */
    private  String goodInfo;
    /**
     *  商品详情
     */
    private  String goodInfodetail;
    /**
     *  商品性能文字介绍
     */
    private  String goodxnword;
    /**
     *  商品性能url
     */
    private  String goodxnurl;
    /**
     *  商品功能文字
     */
    private  String goodgnword;
    /**
     *  商品功能url
     */
    private  String goodgnurl;
    /**
     * 无参构造方法
     */
    public GoodEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "good_Id", nullable = false, precision = 0 )
    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }
    @Basic
    @Column(name = "second_id")
    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    @Basic
    @Column(name = "good_name")

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
    @Basic
    @Column(name = "good_info")
    public String getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(String goodInfo) {
        this.goodInfo = goodInfo;
    }
    @Basic
    @Column(name = "good_info_detail")
    public String getGoodInfodetail() {
        return goodInfodetail;
    }

    public void setGoodInfodetail(String goodInfodetail) {
        this.goodInfodetail = goodInfodetail;
    }
    @Basic
    @Column(name = "good_xn_word")
    public String getGoodxnword() {
        return goodxnword;
    }

    public void setGoodxnword(String goodxnword) {
        this.goodxnword = goodxnword;
    }
    @Basic
    @Column(name = "good_xn_url")
    public String getGoodxnurl() {
        return goodxnurl;
    }

    public void setGoodxnurl(String goodxnurl) {
        this.goodxnurl = goodxnurl;
    }
    @Basic
    @Column(name = "good_gn_word")
    public String getGoodgnword() {
        return goodgnword;
    }

    public void setGoodgnword(String goodgnword) {
        this.goodgnword = goodgnword;
    }
    @Basic
    @Column(name = "good_gn_url")
    public String getGoodgnurl() {
        return goodgnurl;
    }

    public void setGoodgnurl(String goodgnurl) {
        this.goodgnurl = goodgnurl;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodEntity that = (GoodEntity) o;
        return Objects.equals(secondId, that.secondId) &&
                Objects.equals(goodId, that.goodId) &&
                Objects.equals(goodName, that.goodName) &&
                Objects.equals(goodInfo, that.goodInfo) &&
                Objects.equals(goodInfodetail, that.goodInfodetail) &&
                Objects.equals(goodxnword, that.goodxnword) &&
                Objects.equals(goodxnurl, that.goodxnurl) &&
                Objects.equals(goodgnword, that.goodgnword) &&
                Objects.equals(goodgnurl, that.goodgnurl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(secondId, goodId, goodName, goodInfo, goodInfodetail, goodxnword, goodxnurl, goodgnword, goodgnurl);
    }
}
