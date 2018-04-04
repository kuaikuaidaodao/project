package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.biz.ILinkService;
import com.example.demo.common.Message;
import com.example.demo.dao.ILinkRepository;
import com.example.demo.entity.LinkEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月28日 上午10:10:51
 * @desc 友情链接
 */
@Controller
@RequestMapping("/link")
public class LinkController {

	@Autowired
	ILinkRepository linkRepository;
	@Autowired
	ILinkService linkService;

	// 添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(LinkEntity link) {
		if (link.getName()==null || "".equals(link.getName())) {
			return Message.LINK_NAME;
		}
		if (link.getName().length()>30) {
			return Message.LINK_NAME_NUM;
		}
		if (link.getNameEn()==null || "".equals(link.getNameEn())) {
			return Message.LINK_NAME_EN;
		}
		if (link.getNameEn().length()>100) {
			return Message.LINK_NAME_EN_MUN;
		}
		if (link.getUrl()==null || "".equals(link.getUrl())) {
			return Message.LINK_URL;
		}
		if (link.getUrl().length()>100) {
			return Message.LINK_URL_NUM;
		}else {
			linkRepository.saveAndFlush(link);
			return Message.SUCCESS;
		}	
	}

	// 删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		linkRepository.delete(id);
	}

	// 查询所有链接
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return linkService.findAll();
		} else {
			return linkRepository.findAll();
		}
	}

	// 根据id查询链接
	@RequestMapping("/findOne")
	@ResponseBody
	public LinkEntity findOne(Long id) {
		return linkRepository.findOne(id);
	}
}
