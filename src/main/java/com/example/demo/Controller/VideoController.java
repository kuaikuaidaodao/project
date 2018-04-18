package com.example.demo.Controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.biz.IVideoService;
import com.example.demo.common.Message;
import com.example.demo.dao.IVideoRepository;
import com.example.demo.entity.VideoEntity;

/**
 * 
 * @author xwj
 * @date 2018年4月18日 上午9:37:13
 * @desc 视频展示
 */
public class VideoController {

	@Autowired
	private IVideoRepository videoRepository;
	@Autowired
	private IVideoService videoService;

	// 添加和修改
	@RequestMapping("/saveAndFlush")
	@ResponseBody
	public String saveAndFlush(VideoEntity video) {
		try {
			if (video.getName() == null || "".equals(video.getName())) {
				return Message.VIDEO_NAME;
			}
			if (video.getName().length() > 30) {
				return Message.VIDEO_NAME_NUM;
			}
			if (video.getNameEn() == null || "".equals(video.getNameEn())) {
				return Message.VIDEO_NAME_EN;
			}
			if (video.getNameEn().length() > 100) {
				return Message.VIDEO_NAME_EN_NUM;
			} else {
				videoRepository.saveAndFlush(video);
				return Message.SUCCESS;
			}
		} catch (Exception e) {
			return Message.FAILURE;
		}

	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		try {
			videoRepository.delete(id);
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
			return videoService.findAll();
		} else {
			return videoRepository.findAll();
		}
	}

	// 根据id查询视频
	@RequestMapping("/findOne")
	@ResponseBody
	public VideoEntity findOne(Long id) {
		return videoRepository.findOne(id);
	}
}
