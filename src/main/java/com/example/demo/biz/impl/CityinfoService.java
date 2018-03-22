package com.example.demo.biz.impl;

import com.example.demo.biz.ICityinfoService;

import com.example.demo.dao.ICityinfoDao;
import com.example.demo.dao.ICityinfoRepository;
import com.example.demo.entity.cityinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:51
 * @desc 城市信息
 **/
@Service
public class CityinfoService implements ICityinfoService {
    @Autowired
    ICityinfoDao iCityinfoDao;
    @Autowired
    ICityinfoRepository iCityinfoRepository;
    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'demoInfo_city'";

    public static final String DEMO_CACHE_NAME = "demo";
    @Override
    public Object getType() {
        return iCityinfoDao.getType();
    }

    @Override
    @Cacheable(value=DEMO_CACHE_NAME,key=CACHE_KEY)
    public List<cityinfoEntity> findAll() {
        return iCityinfoRepository.findAll();
    }

    @Override
    @CacheEvict(value=DEMO_CACHE_NAME ,key=CACHE_KEY )
    public void delete(String ids) {
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                iCityinfoRepository.delete(Long.valueOf(id));
        }
    }

    @Override
    @CacheEvict(value=DEMO_CACHE_NAME ,key=CACHE_KEY )
    public void saveAndflush(cityinfoEntity cityinfoEntity) {
        iCityinfoRepository.saveAndFlush(cityinfoEntity);
    }

    @Override
    public List<cityinfoEntity> getInfoByType(String type) {
        return iCityinfoDao.getInfoByType(type);
    }

    @Override
    public List<cityinfoEntity> findCheck() {
        return iCityinfoDao.findCheck();
    }
    @Override
    public List<cityinfoEntity> findNoCheck() {
        return iCityinfoDao.findNoCheck();
    }
    @Override
    public cityinfoEntity findOne(String id) {
        return iCityinfoRepository.findOne(Long.valueOf(id));
    }
}
