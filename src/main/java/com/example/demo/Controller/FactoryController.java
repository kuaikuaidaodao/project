package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IFactoryService;
import com.example.demo.common.Message;
import com.example.demo.dao.IFactoryRepository;
import com.example.demo.entity.FactoryEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月9日 上午9:50:23
 * @desc 工厂展示
 */
@Controller
@RequestMapping("/factory")
public class FactoryController {
	
	@Autowired
	private IFactoryRepository factoryRepository;
	@Autowired
	private IFactoryService factoryService;

	//添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(FactoryEntity factory) {
		if (factory.getName() == null || "".equals(factory.getName())) {
			return Message.FACTORY_NAME;
		}
		if (factory.getName().length()>30) {
			return Message.FACTORY_NAME_NUM;
		}
		if (factory.getNameEn() == null || "".equals(factory.getNameEn())) {
			return Message.FACTORY_NAME_EN;
		}
		if (factory.getNameEn().length()>100) {
			return Message.FACTORY_NAME_EN_NUM;
		}else {
			factoryRepository.saveAndFlush(factory);
			return Message.SUCCESS;
		}	
	}
	
	//删除
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		try {
			factoryRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}
	
	//查询所有区分中英文
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return factoryService.findAll();
		} else {
			return factoryRepository.findAll();
		}
	}
	
	//根据id查询信息
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(Long id) {
		return factoryRepository.findOne(id);
	}
}
