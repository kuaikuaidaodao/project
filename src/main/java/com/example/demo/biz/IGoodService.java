package com.example.demo.biz;

import com.example.demo.entity.GoodEntity;
import com.example.demo.entity.UserinfoEntity;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
public interface IGoodService {

    List<GoodEntity> selectBySecondId(Long second_id);
}
