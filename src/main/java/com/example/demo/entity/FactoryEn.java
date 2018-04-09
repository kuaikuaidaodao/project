package com.example.demo.entity;
/**
 * 
 * @author xwj
 * @date 2018年4月9日 上午9:35:16
 * @desc 工厂英文版
 */
public class FactoryEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 英文名称
	 */
	private String name;
	
	/**
	 * 英文描述
	 */
	private String context;
	
	/**
	 * 图片地址
	 */
	private String iamgeUrl;
	
	/**
	 * 排序
	 */
	private Long sort;

	public FactoryEn() {
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getIamgeUrl() {
		return iamgeUrl;
	}

	public void setIamgeUrl(String iamgeUrl) {
		this.iamgeUrl = iamgeUrl;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
}
