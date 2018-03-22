package com.example.demo.Controller;

import com.example.demo.biz.IGoodService;
import com.example.demo.biz.IUserinfoService;
import com.example.demo.dao.IGoodRepository;
import com.example.demo.entity.GoodEntity;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author li
 * @create 2018-03-20 15:54
 * @desc dis
 **/
@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    IGoodService iGoodService;
    @Autowired
    IGoodRepository iGoodRepository;

    /*
     * 查全部
    */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<GoodEntity> findAll(){
        List<GoodEntity> goodEntity=iGoodRepository.findAll();

        return goodEntity;

    }
   /*
     增加 修改
    */
    @RequestMapping("/saveAndflush")
    @ResponseBody
    public void saveAndflush(GoodEntity goodEntity){
        iGoodRepository.saveAndFlush(goodEntity);
    }
     /*
     删除
    */
    @RequestMapping("/delete")
    public void delete(String ids){
        String[] idss=ids.split(",");
        if (idss.length>0) {
            for (String id : idss)
                iGoodRepository.delete(Long.valueOf(id));
        }
    }
    /**
     * selectById
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public GoodEntity selectById(Long id){
        GoodEntity goodEntity=iGoodRepository.findOne(id);
        return goodEntity;

    }
    /**
     * selectBySecondId
     */
    @RequestMapping("/selectBySecondId")
    @ResponseBody
    public List<GoodEntity> selectBySecondId(Long second_id){
        List<GoodEntity> goodEntity=iGoodService.selectBySecondId(second_id);
        return goodEntity;

    }
}
