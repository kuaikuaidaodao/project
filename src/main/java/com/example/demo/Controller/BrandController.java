package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IBrandService;
import com.example.demo.common.Message;
import com.example.demo.dao.IBrandRepository;
import com.example.demo.entity.BrandEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月12日 下午2:32:15
 * @desc 其他品牌
 */
@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private IBrandService brandService;
	@Autowired
	private IBrandRepository brandRepository;

	//添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(BrandEntity brand) {
		if (brand.getName().length()>30) {
			return Message.BRAND_NAME;
		}
		if (brand.getNameEn().length()>100) {
			return Message.BRAND_NAME_EN_NUM;
		}
		if (brand.getUrl().length()>100) {
			return Message.BRAND_URL_NUM;
		}
		if (brand.getSort()>999) {
			return Message.BRAND_SORT;
		}else {
			brandRepository.saveAndFlush(brand);
			return Message.SUCCESS;
		}
	}
	
	//删除
	@RequestMapping("/delete")
	public String delete(Long id) {
		try {
			brandRepository.delete(id);
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
			return brandService.findAll();
		} else {
			return brandRepository.findAll();
		}
	}
	
	//根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(Long id) {
		return brandRepository.findOne(id);
	}
}
