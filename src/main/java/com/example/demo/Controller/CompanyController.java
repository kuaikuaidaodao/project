package com.example.demo.Controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.biz.ICompanyService;
import com.example.demo.common.Message;
import com.example.demo.dao.ICompanyRepository;
import com.example.demo.entity.CompanyEntity;

/**
 * @author xwj
 * @date 2018年3月28日 下午5:57:54
 * @desc 公司简介
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	ICompanyService companyService;
	@Autowired
	ICompanyRepository companyRepository;

	// 添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(CompanyEntity companyEntity) {
		if (companyEntity.getName()==null || "".equals(companyEntity.getName())) {
			return Message.COMPANY_NAME;
		}
		if (companyEntity.getName().length()>30) {
			return Message.COMPANY_NAME_NUM;
		}
		if (companyEntity.getNameEn()==null || "".equals(companyEntity.getNameEn())) {
			return Message.COMPANY_NAME_EN;
		}
		if (companyEntity.getNameEn().length()>100) {
			return Message.COMPANY_NAME_EN_NUM;
		}
		if (companyEntity.getAddress()==null || "".equals(companyEntity.getAddress())) {
			return Message.COMPANY_ADDRESS;
		}
		if (companyEntity.getAddress().length()>200) {
			return Message.COMPANY_ADDRESS_NUM;
		}
		if (companyEntity.getAddressEn()==null || "".equals(companyEntity.getAddressEn())) {
			return Message.COMPANY_ADDRESS_EN;
		}
		if (companyEntity.getAddressEn().length()>200) {
			return Message.COMPANY_ADDRESS_EN_NUM;
		}
		if (companyEntity.getPhone()==null || "".equals(companyEntity.getPhone())) {
			return Message.COMPANY_PHONE;
		}
		if (companyEntity.getPhone().length()>15) {
			return Message.COMPANY_PHONE_NUM;
		}else {
			companyRepository.saveAndFlush(companyEntity);
			return Message.SUCCESS;
		}
		
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		try {
			companyRepository.delete(id);
			return Message.SUCCESS;		
		} catch (Exception e) {
			return Message.FAILURE;
		}	
	}

	// 查询所有信息
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return companyService.findAll();
		} else {
			return companyRepository.findAll();
		}
	}

	// 查询单个信息
	@RequestMapping("/findOne")
	@ResponseBody
	public CompanyEntity findOne(Long id) {
		return companyRepository.findOne(id);
	}
}
