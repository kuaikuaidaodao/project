package com.example.demo.entity;

import java.util.Date;

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
 * @date 2018年4月3日 上午10:02:28
 * @desc 新闻
 */
@Entity
@Table(name="news")
public class NewsEntity {

	//主键id
	private Long id;
	
	//名称
	private String name;
	
	//英文名称
	private String nameEn;
	
	//内容
	private String context;
	
	//英文内容
	private String contextEn;
	
	//图片地址
	private String imgurl;
	
	//作者名称
	private String writer;
	
	//作者英文名
	private String writerEn;
	
	//来源
	private String resource;
	
	//来源英文
	private String resourceEn;
	
	//添加时间
	private Date time;
	
	//类型 0表示公司新闻  1表示行业新闻
	private Long type;

	public NewsEntity() {
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
	 @Column(name = "imgurl")
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Basic
	 @Column(name = "writer")
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Basic
	 @Column(name = "writer_en")
	public String getWriterEn() {
		return writerEn;
	}

	public void setWriterEn(String writerEn) {
		this.writerEn = writerEn;
	}

	@Basic
	 @Column(name = "resource")
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Basic
	 @Column(name = "resource_en")
	public String getResourceEn() {
		return resourceEn;
	}

	public void setResourceEn(String resourceEn) {
		this.resourceEn = resourceEn;
	}

	@Basic
	 @Column(name = "time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Basic
	 @Column(name = "type")
	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
}
