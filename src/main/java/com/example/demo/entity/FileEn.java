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
 * @date 2018年3月27日 上午10:06:01
 * @description  文件英文名
 */
public class FileEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 文件英文名
	 */
	private String fileEnName;
	/**
	 * 文件地址
	 */
	private String fileUrl;
	/**
	 * 图片地址
	 */
	private String imgUrl;

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public FileEn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileEnName() {
		return fileEnName;
	}

	public void setFileEnName(String fileEnName) {
		this.fileEnName = fileEnName;
	}
}
