package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午10:49:22
 * @desc 公司详情
 */
@Entity
@Table(name="company")
public class CompanyEntity {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 公司中文名称
	 */
	private String name;
	
	/**
	 * 公司英文名称
	 */
	private String nameEn;
	
	/**
	 * 中文图片地址
	 */
	private String imgurl;
	
	/**
	 * 英文图片地址
	 */
	private String imgurlEn;
	
	/**
	 * 中文简介
	 */
	private String desc;
	
	/**
	 * 英文简介
	 */
	private String descEn;
	
	/**
	 * 中文公司地址
	 */
	private String address;
	
	/**
	 * 英文公司地址
	 */
	private String addressEn;
	
	/**
	 * 联系电话
	 */
	private String phone;

	public CompanyEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name="persistenceGenerator",strategy="increment")
	@Column(name= "ID",nullable = false,precision = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name="name_en")
	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Basic
	@Column(name="imgurl")
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Basic
	@Column(name="imgurl_en")
	public String getImgurlEn() {
		return imgurlEn;
	}

	public void setImgurlEn(String imgurlEn) {
		this.imgurlEn = imgurlEn;
	}

	@Basic
	@Column(name="descr")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Basic
	@Column(name="descr_en")
	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	@Basic
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
	@Column(name="address_en")
	public String getAddressEn() {
		return addressEn;
	}

	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}

	@Basic
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
