package com.example.demo.biz.impl;

import com.example.demo.biz.ICatalogService;
import com.example.demo.biz.IGoodService;
import com.example.demo.dao.ICatalogDao;
import com.example.demo.dao.ICatalogRepository;
import com.example.demo.dao.ISecondRepository;
import com.example.demo.entity.FirstlevelEntity;
import com.example.demo.entity.SecondlevelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
@Service
public class CatalogService implements ICatalogService {
    @Autowired
    ICatalogRepository iCatalogRepository;
    @Autowired
    ISecondRepository iSecondRepository;
    @Autowired
    ICatalogDao iCatalogDao;
    @Autowired
    IGoodService iGoodService;
    @Override
    public List<FirstlevelEntity> findAll() {
        return iCatalogRepository.findAll();
    }

    @Override
    public void saveAndflush(FirstlevelEntity firstlevelEntity) {
        iCatalogRepository.saveAndFlush(firstlevelEntity);
    }

    @Override
    public void delete(String ids) {
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                if (null==this.findByFirstId(Long.valueOf(id))) {
                    iCatalogRepository.delete(Long.valueOf(id));
                }
        }
    }

    @Override
    public List<SecondlevelEntity> findByFirstId(Long firstId) {
        return iCatalogDao.findByFirstId(firstId);
    }

    @Override
    public void saveAndflushSecond(SecondlevelEntity secondlevelEntity) {
        iSecondRepository.saveAndFlush(secondlevelEntity);
    }

    @Override
    public void deleteSecond(String ids) {
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss){
                if (null!=iGoodService.selectBySecondId(Long.valueOf(id)) ){
                    iSecondRepository.delete(Long.valueOf(id));
                }
                }
        }
    }
}
