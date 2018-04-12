package com.example.demo.entity;

/**
 * 
 * @author xwj
 * @date 2018年4月11日 下午2:27:45
 * @desc 联系方式国际化
 */
public class ContactEn {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 国际电话
	 */
	private String phone;
	
	/**
	 * 国际传真
	 */
	private String fax;
	
	/**
	 * 国际邮政编码
	 */
	private String pc;
	
	/**
	 * 国际邮箱
	 */
	private String email;

	public ContactEn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
