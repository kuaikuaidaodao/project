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
 * @date 2018年3月30日 下午1:28:08
 * @desc 资历证书
 */
@Entity
@Table(name="cretificate")
public class CertificateEntity {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 证书图片地址
	 */
	private String imageUrls;
	
	/**
	 * 内容
	 */
	private String context;
	
	/**
	 * 内容英文版
	 */
	private String contextEn;

	public CertificateEntity() {
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
	@Column(name="image_urls")
	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
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
	@Column(name="context_en")
	public String getContextEn() {
		return contextEn;
	}

	public void setContextEn(String contextEn) {
		this.contextEn = contextEn;
	}
}
