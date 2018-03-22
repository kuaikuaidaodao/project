package com.example.demo.Controller;

import com.example.demo.biz.ICatalogService;
import com.example.demo.entity.FirstlevelEntity;
import com.example.demo.entity.SecondlevelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author li
 * @create 2018-03-20 15:10
 * @desc 目录查询
 **/
@Controller
@RequestMapping("catalog")
public class CatalogController {
  @Autowired
  ICatalogService iCatalogService;
  /*
     一级目录查询
   */
    @RequestMapping("firstlevel_find")
    @ResponseBody
    public List<FirstlevelEntity> firstlevelfind(){
        return iCatalogService.findAll();
    }
  /*
   一级目录增加 修改
 */
  @RequestMapping("saveAndflush")
  public void firstlevelfind(FirstlevelEntity firstlevelEntity){
    iCatalogService.saveAndflush(firstlevelEntity);
  }
  /*
     一级目录删除
   */
  @RequestMapping("delete")
  public void delete(String ids){
    iCatalogService.delete(ids);
  }
  /*
     二级目录查询
   */
  @RequestMapping("secondlevel_find")
  @ResponseBody
  public List<SecondlevelEntity> secondlevel_find(Long firstId){
    return iCatalogService.findByFirstId(firstId);
  }
  /**
   * 二级目录增加修改
   */
  @RequestMapping("saveAndflushSecond")
  public void saveAndflushSecond(SecondlevelEntity secondlevelEntity){
    iCatalogService.saveAndflushSecond(secondlevelEntity);
  }
  /**
   * 二级目录删除
   */
  @RequestMapping("deleteSecond")
  public void deleteSecond(String  ids){
    iCatalogService.deleteSecond(ids);
  }
  /**
   *@Author:liyong
   *@Description: 轮播图上传
   *@Date: 14:23 2017/11/27
   */
  @RequestMapping("/addPic")
  @ResponseBody
  //处理文件上传
  public  String uploadImg(@RequestParam("file") MultipartFile file,
                                        HttpServletRequest request) {
//    String contentType = file.getContentType();
    String filePath=null;
    String ss=null;
    String fileName = file.getOriginalFilename();
    //获取跟目录
    File path = null;
    try {
      path = new File(ResourceUtils.getURL("classpath:").getPath());
      System.out.println(path);

    if(!path.exists()) {
      path = new File("");
    }
//如果上传目录为/static/images/upload/，则可以如下获取：
    File load = new File(path.getAbsolutePath(),"static/images/upload\\");
    if(!load.exists()) {load.mkdirs();}
    System.out.println("upload url:"+load.getAbsolutePath());
    filePath=load.getAbsolutePath();
      File targetFile = new File(load.getAbsolutePath());
      if(!targetFile.exists()){
        targetFile.mkdirs();
      }
                //格式化日期
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
      fileName=format.format(new Date())+fileName;

      ss=filePath+"/"+fileName;
      FileOutputStream out = new FileOutputStream(ss);
      out.write(file.getBytes());
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //返回json
    return fileName;
  }
}
