
package com.example.demo.Controller;

import com.example.demo.biz.IUserinfoService;
import com.example.demo.common.Des;
import com.example.demo.dao.IUserinfoRepository;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;
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
	public Object login(String userName, String password,HttpServletRequest req, HttpSession session) {
		int i = 1;
		password = Des.encryptBasedDes(password);
		Object userinfo = iUserinfoService.selectByNameAndPassword(userName, password);
		if (userinfo != null && !"".equals(userinfo)) {
			i = 0;
			session.setAttribute("USER_LOGIN", userName);
			System.out.println(req.getSession().getAttribute("USER_LOGIN"));
			return userinfo;
		} else {
			return i;
		}
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USER_LOGIN");
		return "退出成功";
	}

	/*
	 * 登陆
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
			userinfoEntity.setPassword(Des.encryptBasedDes(userinfoEntity.getPassword()));
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
