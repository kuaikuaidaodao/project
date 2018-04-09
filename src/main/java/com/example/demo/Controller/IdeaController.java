package com.example.demo.Controller;
/**
 * 
 * @author xwj
 * @date 2018年4月8日 下午2:30:36
 * @desc 品牌理念
 */

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IdeaService;
import com.example.demo.common.Message;
import com.example.demo.dao.IdeaRepository;
import com.example.demo.entity.IdeaEntity;

@Controller
@RequestMapping("/idea")
public class IdeaController {
	
	@Autowired
	private IdeaRepository ideaRepository;
	@Autowired
	private IdeaService ideaService;

	//添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(IdeaEntity idea) {
		if (idea.getName()==null ||"".equals(idea.getName())) {
			return Message.IDEA_NAME;
		}
		if (idea.getName().length()>30) {
			return Message.IDEA_NAME_NUM;
		}
		if (idea.getNameEn() == null || "".equals(idea.getNameEn())) {
			return Message.IDEA_NAME_EN;
		}
		if (idea.getNameEn().length()>100) {
			return Message.IDEA_NAME_EN_NUM;
		}
		if (idea.getContext() == null || "".equals(idea.getContext())) {
			return Message.IDEA_CONTEXT;
		}else {
			ideaRepository.saveAndFlush(idea);
			return Message.SUCCESS;
		}
	}
	
	//删除
	@RequestMapping("/delete")
	public String delete(Long id) {
		try {
			ideaRepository.delete(id);
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
			return ideaService.findAll();
		} else {
			return ideaRepository.findAll();
		}
	}
	
	//根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public IdeaEntity findOne(Long id) {
		return ideaRepository.findOne(id);
	}
}
