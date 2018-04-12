package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.biz.IManPowerService;
import com.example.demo.dao.IManPowerRepository;
import com.example.demo.entity.ManPowerEntity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午5:49:56
 * @desc 人力资源
 */
@Controller
@RequestMapping("/manPower")
public class ManPowerController {
	@Autowired
	private IManPowerRepository manPowerREpository;
	@Autowired
	private IManPowerService manPowerService;

	//添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public void saveAndFlush(ManPowerEntity manPower) {
		manPowerREpository.saveAndFlush(manPower);
	}
	
	//删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		manPowerREpository.delete(id);
	}
	
	//查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return manPowerService.findAll();
		} else {
			return manPowerREpository.findAll();
		}
	}
	
	//根据条件查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(Long id) {
		return manPowerREpository.findOne(id);
	}
	
	@RequestMapping("/findBookNoQuery")
    public String findBookNoQuery(ModelMap modelMap,@RequestParam(value = "page", defaultValue = "0") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size){
        Page<ManPowerEntity> datas = manPowerService.findBookNoCriteria(page,size);
        System.out.println(datas);
        modelMap.addAttribute("datas", datas);
        return "index1.html";
    }
}
