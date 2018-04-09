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
 * @date 2018年4月8日 下午2:05:18
 * @desc 品牌理念
 */
@Entity
@Table(name="idea")
public class IdeaEntity {

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
	 * 内容
	 */
	private String context;
	
	/**
	 * 英文内容
	 */
	private String contextEn;

	public IdeaEntity() {
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
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	@Basic
	@Column(name="context")
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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
	@Column(name="context_en")
	public String getContextEn() {
		return contextEn;
	}

	public void setContextEn(String contextEn) {
		this.contextEn = contextEn;
	}
}
