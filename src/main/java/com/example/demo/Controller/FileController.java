package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.IFileService;
import com.example.demo.common.Message;
import com.example.demo.dao.IFileRepository;
import com.example.demo.entity.FileEn;
import com.example.demo.entity.FileEntity;

/**
 * @author xwj
 * @date 2018年3月21日 下午1:25:50
 * @description 文件管理
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	IFileRepository fileRepository;
	@Autowired
	IFileService fileService;

	// 修改和添加
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(FileEntity fileEntity) {
		Date d = new Date();
		fileEntity.setTime(d);

		if (fileEntity.getFileName()==null || "".equals(fileEntity.getFileName())) {
			return Message.FILE_NAME;
		}
		if (fileEntity.getFileName().length() > 30) {
			return Message.FILE_NAME_NUM;
		}
		if (fileEntity.getFileEnName()==null || "".equals(fileEntity.getFileEnName())) {
			return Message.FILE_NAME_EN;
		}
		if (fileEntity.getFileEnName().length() > 100) {
			return Message.FILE_NAME_EN_NUM;
		}
		if (fileEntity.getFileUrl().length() <0) {
			return Message.FILE_ZH;
		}		
		if (fileEntity.getFileEnUrl().length()< 0) {
			return Message.FILE_EN;
		}else {
			System.out.println(fileEntity);
			fileRepository.saveAndFlush(fileEntity);
			return Message.SUCCESS;
		}
		
	}

	// 删除
	@RequestMapping("/delete")
	public String delete(Long id) {
		try {
			fileRepository.delete(id);
			return Message.SUCCESS;
		} catch (Exception e) {
			return Message.FAILURE;
		}	
	}

	// 查询所有文件
	@RequestMapping("/findAll")
	@ResponseBody
	public List findAll() {
		Locale locale = LocaleContextHolder.getLocale();
		// System.out.println(locale);
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			// System.out.println("en_US************************");
			return fileService.findAll();
		} else {
			// System.out.println("zh********************");
			return fileRepository.findAll();
		}

	}

	// 根据文件id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public Object findOne(Long id) {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale.toString() != null && locale.toString().equals("en_US")) {
			// System.out.println("en_US************************");
			return fileService.findById(id);
		} else {
			return fileRepository.findOne(id);
		}
	}
}
