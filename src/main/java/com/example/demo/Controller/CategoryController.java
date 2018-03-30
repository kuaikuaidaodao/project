package com.example.demo.Controller;

import com.example.demo.biz.ICatalogService;
import com.example.demo.biz.ICategoryService;
import com.example.demo.dao.ICatalogRepository;
import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author li
 * @create 2018-03-20 15:10
 * @desc 目录查询
 **/
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    ICategoryService iCategoryService;
    /**
     *  查询  前台  中英文
     */
    @RequestMapping("category_find")
    @ResponseBody
    public List menu_find(Long parentId){
        String local= this.local();
        if (local.equals("en_US")){
            return iCategoryService.findAllByEnglish(parentId);
        }else{
            return iCategoryService.findAllByChinese(parentId);
        }

    }





    /**
     * 中英文判断
     */
    public static String local(){
        Locale locale = LocaleContextHolder.getLocale();
        String s=locale.toString();
        if (s.equals("en_US")){
            return "en_US";
        }else{
            return "zh_CN";
        }

    }
}
