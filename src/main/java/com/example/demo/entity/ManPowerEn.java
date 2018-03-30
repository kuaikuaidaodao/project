package com.example.demo.entity;
/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午4:53:55
 * @desc 人力资源英文版
 */
public class ManPowerEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 英文名称
	 */
	private String name;
	
	/**
	 * 排序
	 */
	private int sort;

	public ManPowerEn() {
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}
