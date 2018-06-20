package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IBannerService;
import com.example.demo.common.Message;
import com.example.demo.dao.IBannerRepository;
import com.example.demo.entity.Banner;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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
	public String saveAndflush(Banner banner) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date d = new Date();
		banner.setTime(Timestamp.valueOf(sdf.format(d)));
		try {
			bannerRepository.saveAndFlush(banner);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {	
		try {
			bannerRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}

	// 查询全部
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return bannerService.findAll();
		} else {
			return bannerRepository.findAll();
		}
	}

	//根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Banner findOne(Long id) {
		return bannerRepository.findOne(id);
	}
}
