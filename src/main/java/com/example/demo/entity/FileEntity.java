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
 * @date 2018年3月21日 上午11:34:11
 * @description 文件管理
 */
@Entity
@Table(name="file")
public class FileEntity {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 文件中文名称
	 */
	private String fileName;
	
	/**
	 * 文件地址
	 */
	private String fileUrl;
	
	/**
	 * 图片地址
	 */
	private String imgUrl;
	
	/**
	 * 添加时间
	 */
	private Date time;
	
	/**
	 * 文件英文名
	 */
	private String fileEnName;
	
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
	@Column(name = "file_zh_name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileZhName) {
		this.fileName = fileZhName;
	}

	@Basic
	@Column(name = "file_en_name")
	public String getFileEnName() {
		return fileEnName;
	}

	public void setFileEnName(String fileEnName) {
		this.fileEnName = fileEnName;
	}

	public FileEntity() {
		super();
	}

	@Basic
	@Column(name = "file_url")
	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Basic
	@Column(name = "img_url")
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Basic
	@Column(name = "time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
