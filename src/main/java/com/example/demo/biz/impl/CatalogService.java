package com.example.demo.biz.impl;

import com.example.demo.biz.ICatalogService;
import com.example.demo.biz.IGoodsService;
import com.example.demo.dao.ICatalogRepository;
import com.example.demo.entity.*;
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
public class CatalogService implements ICatalogService {
    @Autowired
    ICatalogRepository iCatalogRepository;
    @Autowired
    IGoodsService iGoodService;

    @Override
    public List<Menu> findAllByEnglish(Long parentId) {
        List<Object[]> list=iCatalogRepository.findAllByEnglish(parentId);
        return  this.cast(list);
    }

    @Override
    public List<Menu> findAllByChinese(Long parentId) {
        List<Object[]> list=iCatalogRepository.findAllByChinese(parentId);
        return  this.cast(list);
    }
    private List<Menu> cast(List<Object[]> list){
        List<Menu> menu=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            Menu menus=new Menu();
            Object[] obj=list.get(i);
            if (null != obj[0]) {
                menus.setMenuId(Long.valueOf(obj[0].toString()));
            }
            if (null != obj[1]) {
                menus.setMenuName(obj[1].toString());
            }
            menu.add(menus);
        }
        return menu;
    }
}
