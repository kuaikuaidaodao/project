package com.example.demo.biz;

import java.util.List;

import com.example.demo.entity.Banner;
import com.example.demo.entity.BannerEn;

/**
 * 
 * @author xwj
 * @date 2018年3月27日 下午3:58:38
 * @desc banner图
 */
public interface IBannerService {

	List<BannerEn> findAll();

}
