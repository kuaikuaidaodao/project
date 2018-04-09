package com.example.demo.entity;

/**
 * 
 * @author xwj
 * @date 2018年4月8日 下午2:15:12
 * @desc 品牌理念英文
 */
public class IdeaEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 英文名称
	 */
	private String name;
	
	/**
	 * 英文内容
	 */
	private String context;

	public IdeaEn() {
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
	
}
