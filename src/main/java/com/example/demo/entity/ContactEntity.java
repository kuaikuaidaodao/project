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
 * @date 2018年4月11日 下午2:16:54
 * @desc 联系方式
 */
@Entity
@Table(name="contact")
public class ContactEntity {

	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	/**
	 * 国际电话
	 */
	private String phoneEn;
	
	/**
	 * 传真
	 */
	private String fax;
	
	/**
	 * 国际传真
	 */
	private String faxEn;
	
	/**
	 * 邮政编码
	 */
	private String pc;
	
	/**
	 * 国际邮编
	 */
	private String pcEn;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 国际邮箱
	 */
	private String emailEn;
	
	/**
	 * 公司地址
	 */
	private String address;
	
	/**
	 * 国际地址
	 */
	private String addressEn;

	public ContactEntity() {
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
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Basic
	@Column(name = "phone_en")
	public String getPhoneEn() {
		return phoneEn;
	}

	public void setPhoneEn(String phoneEn) {
		this.phoneEn = phoneEn;
	}

	@Basic
	@Column(name = "fax")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Basic
	@Column(name = "fax_en")
	public String getFaxEn() {
		return faxEn;
	}

	public void setFaxEn(String faxEn) {
		this.faxEn = faxEn;
	}

	@Basic
	@Column(name = "pc")
	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	@Basic
	@Column(name = "pc_en")
	public String getPcEn() {
		return pcEn;
	}

	public void setPcEn(String pcEn) {
		this.pcEn = pcEn;
	}

	@Basic
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "email_en")
	public String getEmailEn() {
		return emailEn;
	}

	public void setEmailEn(String emailEn) {
		this.emailEn = emailEn;
	}

	@Basic
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
	@Column(name = "address_en")
	public String getAddressEn() {
		return addressEn;
	}

	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}
}
