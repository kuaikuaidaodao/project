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
 * @date 2018年3月28日 上午9:16:57
 * @desc 友情链接
 */
@Entity
@Table(name="link")
public class LinkEntity {

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 链接地址
	 */
	private String url;
	
	/**
	 * 中文名称
	 */
	private String name;
	
	/**
	 * 英文名称
	 */
	private String nameEn;

	public LinkEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name="persistenceGenerator",strategy="increment")
	@Column(name = "ID", nullable = false, precision = 0 )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
}
