package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IBedService;
import com.example.demo.dao.IBedRepository;
import com.example.demo.entity.BedEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午3:57:43
 * @desc 游戏床
 */
@Controller
@RequestMapping("/bed")
public class BedController {

	@Autowired
	private IBedRepository bedRepository;
	@Autowired
	private IBedService bedService;

	//添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public void saveAndFlush(BedEntity bed) {
		bedRepository.saveAndFlush(bed);
	}

	//删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		bedRepository.delete(id);
	}

	//查询全部
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return bedService.findAll();
		} else {
			return bedRepository.findAll();
		}
	}

	//根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return bedService.findById(id);
		} else {
			return bedRepository.findOne(id);
		}
	}
}
