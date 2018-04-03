package com.example.demo.Controller;

import com.example.demo.biz.ICatalogService;
import com.example.demo.dao.ICatalogRepository;
import com.example.demo.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
     * 菜单查询 通过父id 可查询子级菜单
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List findAll( Long parentId){
            return iCatalogRepository.findAllByParentId(parentId);
    }
    /**
     * 通过菜单id  查询菜单详情
     */
    @RequestMapping("findByMenuId")
    @ResponseBody
    public MenuEntity findByMenuId( Long menuId){
        return iCatalogRepository.findOne(menuId);
    }
    /**
     * 菜单  级查
     */
    @RequestMapping("findParent")
    @ResponseBody
    public List findParent(Long menuId){
        List list=new ArrayList();
        Long parentId=null;
        while(true){
             Map map=new HashMap();
            Object object=iCatalogRepository.findmenuName(menuId);
            map.put("menu_id",menuId);
            Object[] obj= (Object[]) object;
            map.put("zh",obj[0].toString());
            map.put("us",obj[1].toString());
            list.add(map);
            parentId=iCatalogRepository.findParent(menuId);
            menuId=parentId;
            if (parentId==0L){
                break;
            }
        }
        return list;

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
  /**
   *@Author:liyong
   *@Description: 文件上传
   *@Date: 14:23 2017/11/27
   */
  @RequestMapping("/addPic")
  @ResponseBody
  //处理文件上传
  public  String uploadImg(@RequestParam("file") MultipartFile file,
                                        HttpServletRequest request) {
    String filePath=null;
    String ss=null;
    String fileName = file.getOriginalFilename();
    fileName=fileName.substring(fileName.lastIndexOf("."));
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
