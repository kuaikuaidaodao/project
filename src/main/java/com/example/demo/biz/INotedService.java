package com.example.demo.biz;

import com.example.demo.entity.notepadEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 14:53
 * @desc dis
 **/

@Transactional
public interface INotedService {


//查询全部
    List<notepadEntity> findAll();


//删除
    void delete(String ids);


//保存
void saveAndflush(notepadEntity notepadEntity);

//公司名称
    List<notepadEntity> findByCompanyName(String companyName);
// geren
    List<notepadEntity> findByUserKey(String userKey);
    // 共享
    List<notepadEntity> findByShare();
//一条
    notepadEntity findOne(String id);
}
