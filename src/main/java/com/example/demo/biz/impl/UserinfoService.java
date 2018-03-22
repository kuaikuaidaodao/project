package com.example.demo.biz.impl;

import com.example.demo.biz.IUserinfoService;
import com.example.demo.dao.IUserinfoDao;
import com.example.demo.dao.IUserinfoRepository;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
@Service
public class UserinfoService implements IUserinfoService {
    @Autowired
    IUserinfoDao iUserinfoDao;
    @Autowired
    IUserinfoRepository iUserinfoRepository;
    @Override
    public List<UserinfoEntity> selectByNameAndPassword(String userName, String password) {
        return iUserinfoDao.selectByNameAndPassword(userName,password);
    }
    @Override
    public void delete(String ids) {
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                iUserinfoRepository.delete(Long.valueOf(id));
        }
    }

    @Override
    public List<UserinfoEntity> findAll() {
        return iUserinfoRepository.findAll();
    }

    @Override
    public  void  saveAndflush(UserinfoEntity userinfoEntity) {
        iUserinfoRepository.saveAndFlush(userinfoEntity);
    }
}
