package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.IFileRepository;
import com.example.demo.entity.FileEntity;

/**
 * @author xwj
 * @date 2018年3月21日 下午1:25:50
 * @description  文件管理
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	IFileRepository fileRepository;
	
	//修改和添加
	@RequestMapping("/saveAndFlush")
	public void saveAndFlush(@RequestBody FileEntity fileEntity) {
		fileRepository.saveAndFlush(fileEntity);
	}
	
	//删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		fileRepository.delete(id);
	}
	
	//查询所有文件
	@RequestMapping("/findAll")
	@ResponseBody
	public List<FileEntity> findAll(){
		return fileRepository.findAll();
	}
	
	//根据文件id查询
	@RequestMapping("/findOne")
	@ResponseBody
	public FileEntity findOne(Long id) {
		return fileRepository.findOne(id);				
	}
}
