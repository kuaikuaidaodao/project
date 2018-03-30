package com.example.demo.biz;

import com.example.demo.entity.Category;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.Menu;

import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
public interface ICategoryService {
//   List<FirstlevelEntity> findAll();
////增加 修改
//    void saveAndflush(FirstlevelEntity firstlevelEntity);
//  // 删除
//   void delete(String ids);
////通过一级目录查二级目录
//    List<SecondlevelEntity> findByFirstId(Long firstId);
////    二级目录增加 修改
// void saveAndflushSecond(SecondlevelEntity secondlevelEntity);
//    // delete 二级目录
//    void deleteSecond(String ids);
//  查询一级菜单 english
    List<Category> findAllByEnglish(Long parentId);
    //  查询一级菜单 chinese
    List<Category> findAllByChinese(Long parentId);
}
