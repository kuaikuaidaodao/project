package com.example.demo.Controller;

import com.example.demo.biz.ICatalogService;
import com.example.demo.biz.ICategoryService;
import com.example.demo.dao.ICatalogRepository;
import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.Category;
import com.example.demo.entity.CategoryEntity;
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
 * @desc 类目查询
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
    public List category_find(Long parentId){
        String local= this.local();
        if (local.equals("en_US")){
            return iCategoryService.findAllByEnglish(parentId);
        }else{
            return iCategoryService.findAllByChinese(parentId);
        }

    }
    /**
     *  查询  前台  中英文
     */
    @RequestMapping("category_findAll")
    @ResponseBody
    public List category_findAll(Long parentId){

            return iCategoryRepository.categoryfindAll(parentId);

    }
    /**
     * 商品类目增加 修改
     */
    @RequestMapping("saveAndflush")
    public void saveAndflush(CategoryEntity category){
        iCategoryRepository.saveAndFlush(category);
    }
    /**
     * 商品类目单个查询 通过类目id  后台使用 查询为单个全部信息
     */
    @RequestMapping("findOne")
    @ResponseBody
    public CategoryEntity findOne(Long categoryId){
        return iCategoryRepository.findOne(categoryId);
    }
    /**
     * 商品类目单个查询 通过类目id  前台使用 根据中英文  有不同结果
     */
    @RequestMapping("findOneByLocal")
    @ResponseBody
    public Category findOneByLocal(Long categoryId){
        String local= this.local();
        if (local.equals("en_US")){
            return iCategoryService.findOneByEnglish(categoryId);
        }else{
            return iCategoryService.findOneByChinese(categoryId);
        }
    }
    /**
     * 类目  级查
     */
    @RequestMapping("findParent")
    @ResponseBody
    public List findParent(Long categoryId){
        List list=new ArrayList();
        Long parentId=null;
        while(true){
            Map map=new HashMap();
            Object object=iCategoryRepository.findcategoryName(categoryId);
            map.put("category_id",categoryId);
            Object[] obj= (Object[]) object;
            map.put("zh",obj[0].toString());
            map.put("us",obj[1].toString());
            list.add(map);
            parentId=iCategoryRepository.findParent(categoryId);
            categoryId=parentId;
            if (parentId==0L){
                break;
            }
        }
        return list;

    }
    /**
     * 类目删除
     */
    @RequestMapping("delete")
    public void delete(String ids){
        String[] idss=ids.split(",");
        for (String id:idss) {
            iCategoryRepository.delete(Long.valueOf(id));
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
