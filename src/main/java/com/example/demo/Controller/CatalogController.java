package com.example.demo.Controller;

import com.example.demo.biz.ICatalogService;
import com.example.demo.common.Common;
import com.example.demo.dao.ICatalogRepository;
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
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

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
    @Autowired
    ICatalogRepository iCatalogRepository;
  /**
    * 菜单查询
   */
    @RequestMapping("menu_find")
    @ResponseBody
    public List menu_find(Long parentId){
        String local= this.local();
        if (local.equals("en_US")){
            return iCatalogService.findAllByEnglish(parentId);
        }else{
            return iCatalogService.findAllByChinese(parentId);
        }

    }
    /**
     * 菜单查询
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List findAll(Long parentId){

            return iCatalogRepository.findAllByParentId(parentId);

    }
  /**
   *菜单增加 修改
 */
  @RequestMapping("saveAndflush")
  public void firstlevelfind(MenuEntity menuEntity){
      iCatalogRepository.saveAndFlush(menuEntity);
  }
  /**
    * 菜单删除
   */
  @RequestMapping("delete")
  public void delete(String ids){
      String[] idss=ids.split(",");
      for (String id:idss) {
          iCatalogRepository.delete(Long.valueOf(id));
      }
  }
//  /**
//     二级菜单查询
//   */
//  @RequestMapping("menu_find_")
//  @ResponseBody
//  public List<SecondlevelEntity> secondlevel_find(Long parentId){
//    return iCatalogService.findByFirstId(firstId);
//  }
//  /**parent
//   * 二级目录增加修改
//   */
//  @RequestMapping("saveAndflushSecond")
//  public void saveAndflushSecond(SecondlevelEntity secondlevelEntity){
//    iCatalogService.saveAndflushSecond(secondlevelEntity);
//  }
//  /**
//   * 二级目录删除
//   */
//  @RequestMapping("deleteSecond")
//  public void deleteSecond(String  ids){
//    iCatalogService.deleteSecond(ids);
//  }
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
  @RequestMapping("/test")
  @ResponseBody
 public  String test(){
    String s=null;
    try {
      System.out.println("------------------------------------");
      Properties props = new Properties();
      props.load(new FileReader(ResourceUtils.getURL("classpath:").getPath()+"\\messages_en_US.properties"));
      System.out.println(props.getProperty("kitty"));
//      props.setProperty("kitty", iCatalogService.findAll().toString());
      s=props.getProperty("kitty");
//持久化配置文件
      File file = new File(ResourceUtils.getURL("classpath:").getPath()+"\\messages_en_US.properties");
      Writer fw = new FileWriter(file);
      props.store(fw, "conmments");
      fw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return s;
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
