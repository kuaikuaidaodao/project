package com.example.demo.entity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午1:35:12
 * @desc 证书英文版
 */
public class CertificateEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 证书图片地址
	 */
	private String imageUrls;
	
	/**
	 * 内容英文版
	 */
	private String context;

	public CertificateEn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	

}
