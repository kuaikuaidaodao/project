package com.example.demo.biz.impl;

import com.example.demo.biz.ICatalogService;
import com.example.demo.biz.ICategoryService;
import com.example.demo.biz.IGoodsService;
import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @create 2018-02-07 14:14
 * @desc 用户
 **/
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    IGoodsService iGoodService;

    @Override
    public List<Category> findAllByEnglish(Long parentId) {
        List<Object[]> list=iCategoryRepository.findAllByEnglish(parentId);
        return  this.cast(list);
    }

    @Override
    public List<Category> findAllByChinese(Long parentId) {
        List<Object[]> list=iCategoryRepository.findAllByChinese(parentId);
        return  this.cast(list);
    }
    private List<Category> cast(List<Object[]> list){
        List<Category> menu=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            Category category=new Category();
            Object[] obj=list.get(i);
            if (null != obj[0]) {
                category.setCategoryId(Long.valueOf(obj[0].toString()));
            }
            if (null != obj[1]) {
                category.setCategoryName(obj[1].toString());
            }
            menu.add(category);
        }
        return menu;
    }
}
