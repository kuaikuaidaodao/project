package com.example.demo.entity;



import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
/** 
 * @author xwj
 * @date 2018年3月21日 下午1:48:30
 * @description 轮播图
 */
@Entity
@Table(name="banner")
public class Banner {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 图片地址
	 */
	private String imgurl;
	
	/**
	 * 产品id
	 */
	private String goodid;
	
	/**
	 * 产品名称
	 */
	private String goodName;
	
	/**
	 * 添加时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
	
	/**
	 * 英文图片
	 */
	private String imgEnUrl;

	public Banner() {
		super();
	}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment")
	@Column(name = "ID", nullable = false, precision = 0 )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Basic
	 @Column(name = "img_url")
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	 @Basic
	 @Column(name = "good_id")
	public String getGoodid() {
		return goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
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
	 @Column(name = "time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	 @Basic
	 @Column(name = "img_en_url")
	public String getImgEnUrl() {
		return imgEnUrl;
	}

	public void setImgEnUrl(String imgEnUrl) {
		this.imgEnUrl = imgEnUrl;
	}
}
