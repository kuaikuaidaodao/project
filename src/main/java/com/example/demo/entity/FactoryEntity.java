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
 * @date 2018年4月9日 上午9:26:07
 * @desc 工厂
 */
@Entity
@Table(name="factory")
public class FactoryEntity {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 英文名称
	 */
	private String nameEn;
	
	/**
	 * 描述
	 */
	private String context;
	
	/**
	 * 英文描述
	 */
	private String contextEn;
	
	/**
	 * 图片地址
	 */
	private String imageUrl;
	
	/**
	 * 排序
	 */
	private Long sort;

	public FactoryEntity() {
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
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "name_en")
	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Basic
	@Column(name = "context")
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Basic
	@Column(name = "context_en")
	public String getContextEn() {
		return contextEn;
	}

	public void setContextEn(String contextEn) {
		this.contextEn = contextEn;
	}	

	@Basic
	@Column(name = "sort")
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	@Basic
	@Column(name = "image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
