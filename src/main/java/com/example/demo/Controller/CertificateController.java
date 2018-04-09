package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.ICertificateService;
import com.example.demo.common.Message;
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
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String savaAndFlush(CertificateEntity certificate) {
		if (certificate.getContext()==null || "".equals(certificate.getContext())) {
			return Message.CERTIFICATE_CONTEXT;
		}else {
			certificateRepository.saveAndFlush(certificate);
			return Message.SUCCESS;
		}
	}
	
	//删除
	@RequestMapping("/delete")
	public String delete(Long id) {
		try {
			certificateRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}	
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
