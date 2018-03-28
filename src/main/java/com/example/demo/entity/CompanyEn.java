package com.example.demo.entity;

public class CompanyEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 公司英文名称
	 */
	private String name;
	
	/**
	 * 英文图片地址
	 */
	private String imgurl;
	
	/**
	 * 英文简介
	 */
	private String desc;
	
	/**
	 * 英文公司地址
	 */
	private String address;
	
	/**
	 * 联系电话
	 */
	private String phone;

	public CompanyEn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
