package com.example.demo.Controller;

import com.example.demo.biz.IUserinfoService;
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
@RequestMapping("/userinfo")
public class UserinfoController{

    @Autowired
    IUserinfoService iUserinfoService;

   /*
     登陆
    */
   @RequestMapping("/login")
   @ResponseBody
    public int login(String userName,String password){
       int i=1;
       List<UserinfoEntity> userinfo=iUserinfoService.selectByNameAndPassword(userName,password);
       if (userinfo.size()>0){
          i=0;
       }
       return i;

   }
    /*
     登陆
    */
    @RequestMapping("/find")
    @ResponseBody
    public List<UserinfoEntity> find(){
        List<UserinfoEntity> userinfo=iUserinfoService.findAll();

        return userinfo;

    }
    
   /*
     增加 修改
    */
    @RequestMapping("/saveAndflush")
    @ResponseBody
    public void saveAndflush(UserinfoEntity userinfoEntity){
        iUserinfoService.saveAndflush(userinfoEntity);
    }
     /*
     删除
    */
    @RequestMapping("/delete")
    public void delete(String ids){
        iUserinfoService.delete(ids);
    }
}
