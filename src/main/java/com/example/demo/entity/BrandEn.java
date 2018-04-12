package com.example.demo.entity;
/**
 * 
 * @author xwj
 * @date 2018年4月12日 下午2:16:58
 * @desc 英文版品牌
 */
public class BrandEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 英文名称
	 */
	private String name;
	
	/**
	 * 链接
	 */
	private String url;
	
	/**
	 * 图片链接
	 */
	private String imageUrl;
	
	/**
	 * 排序
	 */
	private Long sort;

	public BrandEn() {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
