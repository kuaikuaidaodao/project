package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IBannerService;
import com.example.demo.dao.IBannerRepository;
import com.example.demo.entity.Banner;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 
 * @author xwj
 * @date 2018年3月21日 下午1:47:59
 * @description 轮播图
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	IBannerRepository bannerRepository;
	@Autowired
	IBannerService bannerService;

	// 修改和增加
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public void saveAndflush(Banner banner) {
		Date d = new Date();
		banner.setTime(d);
		bannerRepository.saveAndFlush(banner);
	}

	// 删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		bannerRepository.delete(id);
	}

	// 查询全部
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		
		Locale locale = LocaleContextHolder.getLocale();
		//System.out.println(locale);
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			//System.out.println("en_US************************");
			return bannerService.findAll();
		} else {
			//System.out.println("zh********************");
			return bannerRepository.findAll();
		}
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Banner findOne(Long id) {
		return bannerRepository.findOne(id);
	}

	public void upload() {
		 
		
	}
}
