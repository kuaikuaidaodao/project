package com.example.demo.biz.impl;

import com.example.demo.biz.INotedService;
import com.example.demo.dao.INoteDao;
import com.example.demo.dao.INotedRepository;
import com.example.demo.entity.notepadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 14:51
 * @desc dis
 **/
@Service
public class NotedService implements INotedService{
    @Autowired
    INotedRepository iNotedRepository;
    @Autowired
    INoteDao iNoteDao;
    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'demoInfo'";

    public static final String DEMO_CACHE_NAME = "demo";
    @Override
    @Cacheable(value="demo",key=CACHE_KEY)
    public List<notepadEntity> findAll() {
        return iNotedRepository.findAll();
    }

    @Override
    @CacheEvict(value="demo" ,key=CACHE_KEY )
    public void delete(String ids) {
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                iNotedRepository.delete(Long.valueOf(id));
        }
    }

    @Override
    @CacheEvict(value="demo" ,key=CACHE_KEY)
    public void saveAndflush(notepadEntity notepadEntity) {
        iNotedRepository.saveAndFlush(notepadEntity);
    }

    @Override
    public List<notepadEntity> findByCompanyName(String companyName) {
        StringBuffer sb=new StringBuffer(" from notepadEntity u where 1=1 ");
        if (null!=companyName&&!"".equals(companyName)) {
            System.out.println(companyName+"-----------");
            sb.append(" and u.companyName like '%"+companyName+"%'");
            System.out.println(sb.toString()+"--------------");
        }
        return iNoteDao.findByCompanyName(sb.toString());
    }

    @Override
    public List<notepadEntity> findByUserKey(String userKey) {
        StringBuffer sb=new StringBuffer(" from notepadEntity u where u.userKey=:userKey ");

        return iNoteDao.findByUserKey(userKey);
    }

    @Override
    public List<notepadEntity> findByShare() {
        return iNoteDao.findByShare();
    }

    @Override
    public notepadEntity findOne(String id) {
        return iNotedRepository.findOne(Long.valueOf(id));
    }


}
