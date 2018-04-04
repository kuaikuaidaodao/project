
package com.example.demo.Controller;

import com.example.demo.biz.IUserinfoService;
import com.example.demo.common.Message;
import com.example.demo.dao.IUserinfoRepository;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

/**
 * @author li
 * @create 2018-03-20 15:54
 * @desc dis
 **/
@Controller
@RequestMapping("/userinfo")
public class UserinfoController {

	@Autowired
	IUserinfoService iUserinfoService;
	@Autowired
	IUserinfoRepository iUserinfoRepository;

	/*
	 * 登陆
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object login(String userName, String password, HttpSession session) {
		if ("".equals(userName)||null==userName){
			return Message.usercount;
		} else if ("".equals(userName)||null==userName) {
			return Message.userword;
		}else {
			Object userinfo = iUserinfoService.selectByNameAndPassword(userName, password);
			if (userinfo != null && !"".equals(userinfo)) {
				session.setAttribute("USER_LOGIN", userName);
				return userinfo;
			} else {
				return Message.LoginFaile;
			}
		}
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USER_LOGIN");
		return "退出成功";
	}

	/**
	 * 用户信息  全部
	 */
	@RequestMapping("/find")
	@ResponseBody
	public List<UserinfoEntity> find() {
		List<UserinfoEntity> userinfo = iUserinfoService.findAll();
		return userinfo;

	}

	/*
	 * 增加 修改
	 */
	@RequestMapping("/saveAndflush")
	@ResponseBody
	public String saveAndflush(UserinfoEntity userinfoEntity) {
		String i = "成功";
		try {
			iUserinfoService.saveAndflush(userinfoEntity);
		} catch (Exception e) {
			i = "失败";
		}
		return i;
	}

	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	public void delete(String ids) {
		iUserinfoService.delete(ids);
	}

	/*
	 * 删除
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public UserinfoEntity findOne(String ids) {
		return iUserinfoRepository.findOne(Long.valueOf(ids));
	}
}
