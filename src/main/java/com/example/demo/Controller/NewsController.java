package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.INewsService;
import com.example.demo.common.Message;
import com.example.demo.dao.INewsRepository;
import com.example.demo.entity.NewsEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月3日 上午10:27:58
 * @desc 新闻资讯
 */
@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private INewsRepository newsRepository;
	@Autowired
	private INewsService newsService;

	// 修改和添加
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String savaAndFlush(NewsEntity news) {
		news.setTime(new Date());
		if (news.getName() == null || "".equals(news.getName())) {
			return Message.NEWS_NAME;
		}
		if (news.getName().length() > 30) {
			return Message.NEWS_NAME_NUM;
		}
		if (news.getNameEn() == null || "".equals(news.getNameEn())) {
			return Message.NEWS_NAME_EN;
		}
		if (news.getNameEn().length() > 100) {
			return Message.NEWS_NAME_EN_NUM;
		}
		if (news.getType() == null || "".equals(new String().valueOf(news.getType()))) {
			return Message.NEWS_TyPE;
		}
		if (news.getWriter().length() > 10) {
			return Message.NEWS_WRITER_NUM;
		}
		if (news.getWriterEn().length() > 30) {
			return Message.NEWS_WRITER_EN_NUM;
		}
		if (news.getResource().length() > 30) {
			return Message.NEWS_RESOURCE_NUM;
		}
		if (news.getResourceEn().length() > 100) {
			return Message.NEWS_RESOURCE_EN_NUM;
		} else {
			newsRepository.saveAndFlush(news);
			return Message.SUCCESS;
		}

	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		try {
			newsRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}

	// 根据类型查询所有
	@RequestMapping("/findAllByType")
	@ResponseBody
	public List findAllByType(Long type) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return newsService.findAll(type);
		} else {
			return newsService.findAllByType(type);
		}
	}

	// 查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		return newsRepository.findAll();
	}

	// 根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return newsService.findById(id);
		} else {
			return newsRepository.findOne(id);
		}
	}
}
