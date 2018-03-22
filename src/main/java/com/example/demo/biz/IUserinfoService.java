package com.example.demo.biz;

import com.example.demo.dao.ICatalogRepository;
import com.example.demo.entity.FirstlevelEntity;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
public interface IUserinfoService {
//   登陆
    List<UserinfoEntity> selectByNameAndPassword(String userName, String password);
//增加 修改
    void saveAndflush(UserinfoEntity userinfoEntity);
//    删除
    void  delete(String ids);

    List<UserinfoEntity> findAll();
}
