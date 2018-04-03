package com.example.demo.entity;

import java.util.Date;

/** 
 * @author xwj
 * @date 2018年3月27日 下午3:59:52
 * @desc 英文版轮播图
 */
public class BannerEn {

	/**
	 * 主键id
	 */
	private Long id;
	
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
	private String time;
	
	/**
	 * 英文图片
	 */
	private String imgurl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodid() {
		return goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgUrl) {
		this.imgurl = imgUrl;
	}
}
