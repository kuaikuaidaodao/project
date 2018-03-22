package com.example.demo.dao;

import com.example.demo.entity.notepadEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:21
 * @desc des
 **/

public interface INoteDao {

    List<notepadEntity> findByCompanyName(String companyName);


    List<notepadEntity> findByUserKey(String userKey);


    List<notepadEntity> findByShare();

}
