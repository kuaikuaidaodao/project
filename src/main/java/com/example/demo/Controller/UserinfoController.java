
package com.example.demo.Controller;

import com.example.demo.biz.IUserinfoService;
import com.example.demo.common.Des;
import com.example.demo.common.Message;
import com.example.demo.dao.IUserinfoRepository;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Object login(String userName, String password) {
        Map map=new HashMap();
	    if (null==userName||"".equals(userName)){
	        map.put("status","error");
	        map.put("message",Message.usercount);
	        return  map;
        }else if (null==password||"".equals(password)){
            map.put("status","error");
            map.put("message",Message.userword);
            return  map;
        }else{
            password = Des.encryptBasedDes(password);
            List<UserinfoEntity> userinfo = iUserinfoService.selectByNameAndPassword(userName, password);
            if (userinfo.size()>0) {
                map.put("status","success");
                map.put("message",userinfo);
                return  map;
            } else {
                map.put("status","error");
                map.put("message",Message.LoginFaile);
                return map;
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
	 * 用户信息 全部
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
		String i = "操作成功";
		try {
			if (userinfoEntity.getUserName()==null || "".equals(userinfoEntity.getUserName())) {
				return Message.USER_NAME;
			}
			if (userinfoEntity.getUserName().length()>15) {
				return Message.USER_NAME_NUM;
			}
			if (userinfoEntity.getPassword()==null || "".equals(userinfoEntity.getPassword())) {
				return Message.USER_PASSWORD;
			}
			if (userinfoEntity.getPassword().length()<4 || userinfoEntity.getPassword().length()>10) {
				return Message.USER_PASSWORD_NUM;
			}else {
				userinfoEntity.setPassword(Des.encryptBasedDes(userinfoEntity.getPassword()));
				iUserinfoService.saveAndflush(userinfoEntity);
				return Message.SUCCESS;
			}	
		} catch (Exception e) {
			return Message.FAILURE;
		}		
	}

	/*
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String ids) {
		try {
			iUserinfoService.delete(ids);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}		
	}

	/*
	 * 查看单条信息
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public UserinfoEntity findOne(String ids) {
		return iUserinfoRepository.findOne(Long.valueOf(ids));
	}

}
