package com.example.demo.entity;

/**
 * 
 * @author xwj
 * @date 2018年4月8日 上午9:22:09
 * @desc 画册英文版
 */
public class PhotoEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 英文名称
	 */
	private String name;
	
	/**
	 * 图片地址
	 */
	private String imageUrl;
	
	/**
	 * 排序
	 */
	private Long sort;

	public PhotoEn() {
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

}
