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

	//修改和添加
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public void savaAndFlush(NewsEntity news) {
		news.setTime(new Date());
		newsRepository.saveAndFlush(news);
	}
	
	//删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		newsRepository.delete(id);
	}
	
	//查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll(Long type) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return newsService.findAll(type);
		} else {
			return newsService.findAllByType(type);
		}
    }
	
	//根据id查询
	public Object findOne(Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return newsService.findById(id);
		} else {
			return newsRepository.findOne(id); 
		}
	}
}
