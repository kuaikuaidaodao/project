package com.example.demo.entity;

import java.util.Date;

/**
 * 
 * @author xwj
 * @date 2018年4月3日 上午10:05:06
 * @desc 新闻英文版
 */
public class NewsEn {

	// 主键id
	private Long id;

	// 英文名称
	private String name;

	// 英文内容
	private String context;

	// 图片地址
	private String imgurl;

	// 作者英文名称
	private String writer;

	// 英文来源
	private String resource;

	// 添加时间
	private String time;

	// 类型 0表示公司新闻 1表示行业新闻
	private Long type;

	public NewsEn() {
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

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
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
