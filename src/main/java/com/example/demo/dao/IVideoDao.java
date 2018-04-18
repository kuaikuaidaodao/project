package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.VideoEn;
/**
 * 
 * @author xwj
 * @date 2018年4月18日 上午9:30:29
 * @desc 视频
 */
public interface IVideoDao {

	/**
	 * 查询全部视频
	 * @return
	 */
	List<VideoEn> findAll();
}
