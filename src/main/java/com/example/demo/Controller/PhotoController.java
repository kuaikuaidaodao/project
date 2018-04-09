package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IPhotoService;
import com.example.demo.common.Message;
import com.example.demo.dao.IPhotoRepository;
import com.example.demo.entity.PhotoEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月8日 上午9:44:04
 * @desc 画册
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private IPhotoRepository photoRepository;
	@Autowired
	private IPhotoService photoService;

	// 添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(PhotoEntity photo) {
		try {
			if (photo.getName() == null || "".equals(photo.getName())) {
				return Message.PHOTO_NAME;
			}
			if (photo.getName().length() > 30) {
				return Message.PHOTO_NAME_NUM;
			}
			if (photo.getNameEn() == null || "".equals(photo.getNameEn())) {
				return Message.PHOTO_NAME_EN;
			}
			if (photo.getNameEn().length() > 100) {
				return Message.PHOTO_NAME_EN_NUM;
			} else {
				photoRepository.saveAndFlush(photo);
				return Message.SUCCESS;
			}
		} catch (Exception e) {
			return Message.FAILURE;
		}

	}

	// 删除
	@RequestMapping("/delete")
	public String delete(Long id) {
		try {
			photoRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}
	}

	// 查询所有
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			return photoService.findAll();
		} else {
			return photoRepository.findAll();
		}
	}

	// 根据id查询画册
	@RequestMapping("/findOne")
	@ResponseBody
	public PhotoEntity findOne(Long id) {
		return photoRepository.findOne(id);
	}
}
