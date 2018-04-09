package com.example.demo.Controller;

import com.example.demo.biz.ICategoryService;
import com.example.demo.common.Message;
import com.example.demo.dao.ICategoryRepository;
import com.example.demo.entity.Category;
import com.example.demo.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     *  查询  后台全部
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
    @ResponseBody
    public String saveAndflush(CategoryEntity category){
        try{
        	if (category.getCategoryNameChinese()==null || "".equals(category.getCategoryNameChinese())) {
				return Message.CATEGORY_NAME;
			}
        	if (category.getCategoryNameChinese().length()>30) {
        		return Message.CATEGORY_NAME_NUM;
			}
        	if (category.getCategoryNameEnglish()==null || "".equals(category.getCategoryNameEnglish())) {
        		return Message.CATEGORY_NAME_EN;
			}
        	if (category.getCategoryNameEnglish().length()>100) {
        		return Message.CATEGORY_NAME_EN_NUM;
			}else {
				iCategoryRepository.saveAndFlush(category);
		           return Message.SUCCESS;
			}     
        }catch (Exception e){
           return  Message.FAILURE;
        }
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
    @ResponseBody
    public String delete(String ids){
        String str = deleteyz(ids);
        try{
            if (str.equals(Message.SUCCESS)){
                String[] idss = ids.split(",");
                for (String id : idss) {
                    iCategoryRepository.delete(Long.valueOf(id));
                }
            }
            return Message.SUCCESS;
        }catch (Exception e){
            return Message.FACTORY_NAME;
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
    public String deleteyz(String ids) {
        try {
            String[] idss = ids.split(",");
            String sb = "";
            if (idss != null) {
                for (String id : idss) {
                    List<Long> mm = iCategoryRepository.findCategoryId(Long.valueOf(id));
                    for (Long nn : mm) {
                        iCategoryRepository.delete(nn);
                        sb = sb + nn + ",";
                    }
                    if (sb != null && !"".equals(sb)) {
                        deleteyz(sb.substring(0, sb.length() - 1));
                    }
                }
            }
            return Message.SUCCESS;
        } catch (Exception e) {
            return Message.FAILURE;
        }

    }
}
