package com.example.demo.Controller;

import com.example.demo.biz.ICityinfoService;
import com.example.demo.entity.cityinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author li
 * @create 2018-01-29 15:50
 * @desc 城市信息
 **/
@Controller
@RequestMapping("cityinfo")
public class CityinfoController {
     @Autowired
    ICityinfoService iCityinfoService;
     /*
       *登陆
      */
     @RequestMapping("login")
     public String login(String name,String password,Model model){
         int i=0;
         System.out.println(name+"------------"+password);
         if (name.equals("admin")&&password.equals("123456")){
             List<cityinfoEntity> list=this.findAll();
             model.addAttribute("kitty",list);
             return "cityinfoList";
         }
       return "index";
     }
     /*
      *查询审核已通过
      */
    @RequestMapping("findCheck")
    @ResponseBody
    public List<cityinfoEntity> findCheck(){
        return iCityinfoService.findCheck();
    }
    /*
     *查询审核已通过
     */
    @RequestMapping("findNoCheck")
    @ResponseBody
    public List<cityinfoEntity> findNoCheck(){
        return iCityinfoService.findNoCheck();
    }

    /*
     *查询全部
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List<cityinfoEntity> findAll(){
        return iCityinfoService.findAll();
    }

    /*
     *查询一条
     */
    @RequestMapping("findOne")
    @ResponseBody
    public cityinfoEntity findOne(String id){
        return iCityinfoService.findOne(id);
    }
    /*
     * 删除
     */
    @RequestMapping("delete")
    public void delete(String ids){
        iCityinfoService.delete(ids);
    }
    /*
     * 修改 增加类型
     */
    @RequestMapping("saveAndflush")
    public void saveAndflush(@RequestBody cityinfoEntity cityinfoEntity){
        iCityinfoService.saveAndflush(cityinfoEntity);
    }
    /*
     * 得到信息类型
     */
    @RequestMapping("getType")
    @ResponseBody
    public Object getType(){
        return iCityinfoService.getType();
    }
    @RequestMapping("getInfoByType")
    @ResponseBody
    public  List<cityinfoEntity> getInfoByType(String classify){
        try {
            classify=new String(classify.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return iCityinfoService.getInfoByType(classify);
    }
}
