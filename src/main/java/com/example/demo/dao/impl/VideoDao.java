package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.IVideoDao;
import com.example.demo.dao.IVideoRepository;
import com.example.demo.entity.VideoEn;
@Repository
public class VideoDao implements IVideoDao{

	@Autowired
	private IVideoRepository videoRepository;

	@Override
	public List<VideoEn> findAll() {
		List<Object[]> list = videoRepository.findAllByZh();
		List<VideoEn> videoEns = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			VideoEn videoEn = new VideoEn();
			Object[] obj = list.get(i);
			if (obj[0] != null) {
				videoEn.setId(Long.valueOf(obj[0].toString()));
			}
			if (obj[1] != null) {
				videoEn.setName(obj[1].toString());
			}
			if (obj[2] != null) {
				videoEn.setVideoUrl(obj[2].toString());
			}
			if (obj[3] != null) {
				videoEn.setSort(Long.valueOf(obj[3].toString()));
			}
			videoEns.add(videoEn);
		}
		return videoEns;
	}
}
