package com.example.demo.Controller;

import com.example.demo.biz.IGoodsService;
import com.example.demo.dao.IGoodRepository;
import com.example.demo.entity.GoodEntity;
import com.example.demo.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

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
    IGoodRepository iGoodsRepository;
    /**
     * 查全部 中英文
     */
    @RequestMapping("/goods_find")
    @ResponseBody
    public List goods_find(Long menuId){
        String local= this.local();
        if (local.equals("en_US")){
            return iGoodsService.findGoodsEnglish(menuId);
        }else{
            return iGoodsService.findGoodsChinese(menuId);
        }
    }
    /**
     * 查全部
    */
    @RequestMapping("/findAll")
    @ResponseBody
    public List findAllByMenuId(Long menuId){

            return iGoodsRepository.findAllByMenuId(menuId);

    }
   /**
     *增加 修改
    */
    @RequestMapping("/saveAndflush")
    @ResponseBody
    public void saveAndflush(GoodsEntity goodsEntity){
        iGoodsRepository.saveAndFlush(goodsEntity);
    }
     /**
     *删除
    */
    @RequestMapping("/delete")
    public void delete(String ids){
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                iGoodsRepository.delete(Long.valueOf(id));
        }
    }
    /**
     * selectById
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public GoodsEntity selectById(Long id){
        GoodsEntity goodsEntity=iGoodsRepository.findOne(id);
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
}
