package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.Message;
import com.example.demo.dao.IMessageRepository;
import com.example.demo.entity.MessagesEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月18日 下午3:17:49
 * @desc 留言
 */
@Controller
@RequestMapping("/messages")
public class MessagesController {

	@Autowired
	private IMessageRepository messageRepository;
	
	//添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(MessagesEntity message) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			if (message.getTitle().length()>30) {
				return Message.MESSAGE_TITLE_NUM_EN;
			}if (message.getName()==null || "".equals(message.getName())) {
				return Message.MESSAGE_NAME_EN;
			}if (message.getName().length()>30) {
				return Message.MESSAGE_NAME_NUM_EN;
			}if (message.getEmail()==null || "".equals(message.getEmail())) {
				return Message.MESSAGE_EMAIL_EN;
			}if (message.getEmail().length()>100) {
				return Message.MESSAGE_EMAIL_NUM_EN;
			}if (message.getCompanyName().length()>100) {
				return Message.MESSAGE_COMPANY_NUM_EN;
			}if (message.getPhone().length()>30) {
				return Message.MESSAGE_PHONE_NUM_EN;
			}if (message.getContext()==null || "".equals(message.getContext())) {
				return Message.MESSAGE_CONTEXT_EN;
			}if (message.getContext().length()>10000) {
				return Message.MESSAGE_CONTEXT_NUM_EN;
			}if (message.getAddress().length()>200) {
				return Message.MESSAGE_ADDRESS_NUM_EN;
			}else {
				message.setTime(new Date());
				message.setType((long)0);
				messageRepository.saveAndFlush(message);
				return Message.SUCCESS;
			}
		}if (message.getTitle().length()>30) {
			return Message.MESSAGE_TITLE_NUM;
		}if (message.getName()==null || "".equals(message.getName())) {
			return Message.MESSAGE_NAME;
		}if (message.getName().length()>30) {
			return Message.MESSAGE_NAME_NUM;
		}if (message.getEmail()==null || "".equals(message.getEmail())) {
			return Message.MESSAGE_EMAIL;
		}if (message.getEmail().length()>100) {
			return Message.MESSAGE_EMAIL_NUM;
		}if (message.getCompanyName().length()>100) {
			return Message.MESSAGE_COMPANY_NUM;
		}if (message.getPhone().length()>30) {
			return Message.MESSAGE_PHONE_NUM;
		}if (message.getContext()==null || "".equals(message.getContext())) {
			return Message.MESSAGE_CONTEXT;
		}if (message.getContext().length()>10000) {
			return Message.MESSAGE_CONTEXT_NUM;
		}if (message.getAddress().length()>200) {
			return Message.MESSAGE_ADDRESS_NUM;
		}else {
			message.setTime(new Date());
			message.setType((long)0);
			messageRepository.saveAndFlush(message);
			return Message.SUCCESS;
		}
		
	}
	
	//查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		return messageRepository.findAllByType();
	}
	
	//删除
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		try {
			messageRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}
	
	//根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public MessagesEntity findOne(Long id) {
		MessagesEntity message = messageRepository.findOne(id);
		message.setType((long) 1);
		messageRepository.saveAndFlush(message);
		return message;
	}
}
