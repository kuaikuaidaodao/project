package com.example.demo.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.IBannerRepository;
import com.example.demo.entity.Banner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author xwj
 * @date 2018年3月21日 下午1:47:59
 * @description 轮播图
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	IBannerRepository bannerRepository;

	// 修改和增加
	@RequestMapping("/saveAndFlush")
	public void saveAndflush(@RequestBody Banner banner) {
		bannerRepository.saveAndFlush(banner);
	}

	// 删除
	@RequestMapping("/delete")
	public void delete(Long id) {
		bannerRepository.delete(id);
	}

	// 查询全部
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Banner> findAll() {
		return bannerRepository.findAll();
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Banner findOne(Long id) {
		return bannerRepository.findOne(id);
	}

	public void upload() {
		 
		
	}
}
