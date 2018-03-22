package com.example.demo.Controller;


import com.example.demo.biz.INotedService;
import com.example.demo.entity.notepadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author li
 * @create 2018-01-29 9:38
 * @desc dis
 **/
@RestController
@RequestMapping("notepad")
public class NotepadController {
    @Autowired
    INotedService iNotedService;

    @RequestMapping("findAll")
    public List<notepadEntity> findAll(){
        return iNotedService.findAll();
    }

    /*
    *  共享
    * */
    @RequestMapping("findByShare")
    public List<notepadEntity> findByShare(){
        return iNotedService.findByShare();
    }
    /*
    *
    * 个人
    * */
    @RequestMapping("findByUserKey")
    public List<notepadEntity> findByUserKey(String userKey){
        return iNotedService.findByUserKey(userKey);
    }
    /*
    *
    * 公司
    * */
    @RequestMapping("findByCompanyName")
    public List<notepadEntity> findAll(String companyName){
        try {
            companyName=new String(companyName.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return iNotedService.findByCompanyName(companyName);
    }
    /*
     * 删除
     */
    @RequestMapping("delete")
    public void delete(String ids){
        iNotedService.delete(ids);
    }
    /*
     * 修改 增加类型
     */
    @RequestMapping("saveAndflush")
    public void saveAndflush(@RequestBody notepadEntity notepadEntity){
        iNotedService.saveAndflush(notepadEntity);
    }
    /*
     *查询一条
     */
    @RequestMapping("findOne")
    public notepadEntity findOne(String id){
        return iNotedService.findOne(id);
    }
}
