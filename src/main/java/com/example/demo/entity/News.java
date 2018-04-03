package com.example.demo.entity;

import java.util.Date;

/**
 * 
 * @author xwj
 * @date 2018年4月3日 上午11:21:06
 * @desc 返回给前端的新闻
 */
public class News {

	// 主键id
	private Long id;

	// 名称
	private String name;

	// 英文名称
	private String nameEn;

	// 内容
	private String context;

	// 英文内容
	private String contextEn;

	// 图片地址
	private String imgurl;

	// 作者名称
	private String writer;

	// 作者英文名
	private String writerEn;

	// 来源
	private String resource;

	// 来源英文
	private String resourceEn;

	// 添加时间
	private String time;

	// 类型 0表示公司新闻 1表示行业新闻
	private Long type;

	public News() {
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

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContextEn() {
		return contextEn;
	}

	public void setContextEn(String contextEn) {
		this.contextEn = contextEn;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriterEn() {
		return writerEn;
	}

	public void setWriterEn(String writerEn) {
		this.writerEn = writerEn;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getResourceEn() {
		return resourceEn;
	}

	public void setResourceEn(String resourceEn) {
		this.resourceEn = resourceEn;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

}
