package com.example.demo.entity;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午9:44:36
 * @desc 英文友情链接
 */
public class LinkEn {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 链接地址
	 */
	private String url;

	/**
	 * 英文名称
	 */
	private String name;

	public LinkEn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
