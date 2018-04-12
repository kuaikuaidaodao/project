package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.Message;
import com.example.demo.dao.IContactRepository;
import com.example.demo.entity.ContactEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月11日 下午2:33:34
 * @desc 联系方式
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private IContactRepository contactRepository;
	
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(ContactEntity contact) {
		if (contact.getPhone().length()>30) {
			return Message.CONTACT_PHONE_NUM;
		}
		if (contact.getPhoneEn().length()>30) {
			return Message.CONTACT_PHONE_EN_NUM;
		}
		if (contact.getFax().length()>30) {
			return Message.CONTACT_FAX_NUM;
		}
		if (contact.getFaxEn().length()>30) {
			return Message.CONTACT_FAX_EN_NUM;
		}
		if (contact.getPc().length()>30) {
			return Message.CONTACT_PC_NUM;
		}
		if (contact.getPcEn().length()>30) {
			return Message.CONTACT_PC_EN_NUM;
		}
		if (contact.getEmail().length()>30) {
			return Message.CONTACT_EMAIL_NUM;
		}
		if (contact.getEmailEn().length()>30) {
			return Message.CONTACT_EMAIL_EN_NUM;
		}
		if (contact.getAddress().length()>100) {
			return Message.CONTACT_ADDRESS_NUM;
		}
		if (contact.getAddressEn().length()>200) {
			return Message.CONTACT_ADDRESS_EN_NUM;
		}else {
			contactRepository.saveAndFlush(contact);
			return Message.SUCCESS;
		}			
	}
	
	//删除
	@RequestMapping("/delete")
	public String delete(Long id) {
		try {
			contactRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}
	
	//查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		return contactRepository.findAll();
	}
	
	//根据id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public ContactEntity findOne(Long id) {
		return contactRepository.findOne(id);
	}
}
