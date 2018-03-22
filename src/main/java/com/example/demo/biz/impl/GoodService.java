package com.example.demo.biz.impl;

import com.example.demo.biz.IGoodService;
import com.example.demo.dao.IGoodDao;
import com.example.demo.dao.IGoodRepository;
import com.example.demo.entity.GoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
@Service
public class GoodService implements IGoodService {
    @Autowired
    IGoodDao  iGoodDao;
    @Autowired
    IGoodRepository iGoodRepository;

    @Override
    public List<GoodEntity> selectBySecondId(Long second_id) {
        return iGoodDao.selectBySecondId(second_id);
    }
}
