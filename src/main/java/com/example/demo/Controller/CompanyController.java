package com.example.demo.Controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author xwj
 * @date 2018年3月28日 下午1:35:06
 * @desc 公司详情
 */
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.biz.ICompanyService;
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
	public void saveAndFlush(CompanyEntity companyEntity) {
		companyRepository.saveAndFlush(companyEntity);
	}

	// 删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		companyRepository.delete(id);
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
