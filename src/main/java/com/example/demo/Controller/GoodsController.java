package com.example.demo.Controller;

import com.example.demo.biz.IGoodsService;
import com.example.demo.common.Message;
import com.example.demo.dao.ICategoryRepository;
import com.example.demo.dao.IGoodsRepository;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author li
 * @create 2018-03-20 15:54
 * @desc dis
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    IGoodsService iGoodsService;
    @Autowired
    IGoodsRepository iGoodsRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;
    Set childMenu=new HashSet();
    /**
     * 查全部 中英文
     */
    @RequestMapping("/goods_find")
    @ResponseBody
    public List goods_find(Long categoryId){
        String local= this.local();
        if (local.equals("en_US")){
            return iGoodsService.findGoodsEnglish(categoryId);
        }else{
            return iGoodsService.findGoodsChinese(categoryId);
        }
    }
    /**
     * 通过类别id查商品
    */
    @RequestMapping("/findByCategoryId")
    @ResponseBody
    public List findByCategoryId(Long categoryId){
            Set list=treeMenuList(iCategoryRepository.findAll(),categoryId);
            StringBuffer sb=new StringBuffer("(");
            for (Object li:list){
                sb.append(li.toString()+" ,");
            }
            sb.append(categoryId);
            sb.append(" )");
            return iGoodsService.findByCategoryId(sb.toString());
    }
    /**
     * 全部商品
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List findAll(){
        return iGoodsRepository.findAll();
    }
   /**
     *增加 修改
    */
    @RequestMapping("/saveAndflush")
    @ResponseBody
    public String saveAndflush(GoodsEntity goods){
    	if (goods.getGoodsNameChinese()==null || "".equals(goods.getGoodsNameChinese())) {
			return Message.GOODS_NAME;
		}
    	if (goods.getGoodsNameChinese().length()>30) {
			return Message.GOODS_NAME_NUM;
		}
    	if (goods.getGoodsNameEnglish().length()>100) {
			return Message.GOODS_NAME_EN_NUM;
		}
    	if (goods.getGoodsBrandChinese()==null || "".equals(goods.getGoodsBrandChinese())) {
			return Message.GOODS_BRAND;
		}
    	if (goods.getGoodsBrandChinese().length()>30) {
    		return Message.GOODS_BRAND_NUM;
		} 
    	if (goods.getGoodsBrandEnglish().length()>100) {
			return Message.GOODS_BRAND_EN_NUM;
		}
    	if (goods.getGoodsBulkChinese()==null || "".equals(goods.getGoodsBulkChinese())) {
			return Message.GOODS_BULK;
		}
    	if (goods.getGoodsBulkChinese().length()>30) {
			return Message.GOODS_BULE_NUN;
		}
    	if (goods.getGoodsBulkEnglish().length()>100) {
    		return Message.GOODS_BRAND_EN_NUM;
		}
    	if (goods.getGoodsModelChinese() == null || "".equals(goods.getGoodsModelChinese())) {
			return Message.GOODS_MODEL;
		}
    	if (goods.getGoodsModelChinese().length()>30) {
			return Message.GOODS_MODEL_NUM;
		}
    	if (goods.getGoodsModelEnglish().length()>100) {
			return Message.GOODS_MODEL_EN_NUM;
		}
    	if (goods.getGoodsWeightChinese() ==null || "".equals(goods.getGoodsWeightChinese())) {
			return Message.GOODS_WEIGHT;
		}
    	if (goods.getGoodsWeightChinese().length()>30) {
    		return Message.GOODS_WEIGHT_NUM;
		}
    	if (goods.getGoodsWeightEnglish().length()>100) {
    		return Message.GOODS_WEIGHT_EN_NUM;
		}
    	if (goods.getGoodsNumberChinese()==null || "".equals(goods.getGoodsNumberChinese())) {
    		return Message.GOODS_NUMBER;
		}
    	if (goods.getGoodsNumberChinese().length()>30) {
			return Message.GOODS_NUMBER_NUM;
		}
    	if (goods.getGoodsNumberEnglish().length()>100) {
    		return Message.GOODS_NUMBER_EN_NUM;
		}else {
			iGoodsRepository.saveAndFlush(goods);
	        return Message.SUCCESS;
		}      
    }
     /**
     *删除
    */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String ids){
        try {
            String[] idss=ids.split(",");
            if (idss.length>0) {
                for (String id : idss)
                    iGoodsRepository.delete(Long.valueOf(id));
            }
            return Message.SUCCESS;
        } catch (Exception e) {
           return  Message.FAILURE;
        }
    }
    /**
     * selectByGoodsId 中英文全部查询
     */
    @RequestMapping("/selectByGoodsId")
    @ResponseBody
    public GoodsEntity selectByGoodsId(Long goodsId){
        GoodsEntity goodsEntity=iGoodsRepository.findOne(goodsId);
        return goodsEntity;

    }
    /**
     * selectByGoodsIdSinglon 中英文分开查询
     */
    @RequestMapping("/selectByGoodsIdSinglon")
    @ResponseBody
    public Goods selectByGoodsIdSinglon(Long goodsId){
        String local= this.local();
        if (local.equals("en_US")){
            return iGoodsService.findGoodsByIdEnglish(goodsId);
        }else{
            return iGoodsService.findGoodsByIdChinese(goodsId);
        }
    }
    /**
     * 搜索
     */
    @RequestMapping("/findByGoodsName")
    @ResponseBody
    public GoodsEntity findByGoodsName(String goodsName){
        try {
            goodsName=new String(goodsName.getBytes("ISO-8859-1"),"UTF-8");
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        GoodsEntity goodsEntity=iGoodsRepository.findByGoodsName(goodsName,goodsName);
        return goodsEntity;

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

    /**
     *
     * @param menuList
     * @param CategoryId  查询子节点
     * @return
     */
    public  Set treeMenuList(List<CategoryEntity> menuList, Long CategoryId){
        for(CategoryEntity mu: menuList){
            //遍历出父id等于参数的id，add进子节点集合
            if(mu.getParentId()==CategoryId){
                //递归遍历下一级
                treeMenuList(menuList,mu.getCategoryId());
                childMenu.add(mu.getCategoryId());
            }
        }
        return childMenu;
    }
}
