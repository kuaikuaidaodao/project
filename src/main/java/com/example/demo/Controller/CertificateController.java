package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.ICertificateService;
import com.example.demo.dao.ICertificateRepository;
import com.example.demo.entity.CertificateEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午1:53:33
 * @desc 资历证书
 */
@Controller
@RequestMapping("/certificate")
public class CertificateController {

	@Autowired
	private ICertificateRepository certificateRepository;
	@Autowired
	private ICertificateService certificateService;
	
	//添加和删除
	@RequestMapping("/savaAndFlush")
	@ResponseBody
	public void savaAndFlush(CertificateEntity certificate) {
		certificateRepository.saveAndFlush(certificate);
	}
	
	//删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		certificateRepository.delete(id);
	}
	
	//查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return certificateService.findAll();
		} else {
			return certificateRepository.findAll();
		}
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public CertificateEntity findOne(Long id) {
		return certificateRepository.findOne(id);
	}
}
