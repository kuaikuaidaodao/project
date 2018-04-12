package com.example.demo.Controller;

import com.example.demo.common.Message;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @create 2018-04-11 14:28
 * @desc 资源
 **/
@RestController
@RequestMapping("/resource")
public class ResourceController {
    static final long picMax=10*1024*1024;
    static final long fileMax=10*1024*1024;
    @RequestMapping("/addFile")
    @ResponseBody
    //处理文件上传
    public Object uploadFile(@RequestParam("file") MultipartFile file,
                            HttpServletRequest request) {
        String filePath = null;
        String ss = null;
        Map map=new HashMap();
        if (file.isEmpty()){
            map.put("status","error");
            map.put("message", Message.NULLFILE);
            return map;
        }
        System.out.println(file+"---------");
        System.out.println(fileMax+"---------");
        if (file.getSize()>fileMax){
            map.put("status","error");
            map.put("message", Message.FILEMAX);
            return map;
        }
        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(fileName.lastIndexOf("."));
        String[] str={".rar",".zip",".tar"};
        if (!Arrays.asList(str).contains(fileName)){
            map.put("status","error");
            map.put("message", Message.FILETYPE);
            return map;
        }

        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(path);

            if (!path.exists()) {
                path = new File("");
            }
//如果上传目录为/static/images/upload/，则可以如下获取：
            File load = new File(path.getAbsolutePath(), "static/file/upload\\");
            if (!load.exists()) {
                load.mkdirs();
            }
            System.out.println("upload url:" + load.getAbsolutePath());
            filePath = load.getAbsolutePath();
            File targetFile = new File(load.getAbsolutePath());
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //格式化日期
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            fileName = format.format(new Date()) + fileName;

            ss = filePath + "/" + fileName;
            FileOutputStream out = new FileOutputStream(ss);
            out.write(file.getBytes());
            out.flush();
            out.close();
            map.put("status","success");
            map.put("message", fileName);
            return  map;
        } catch (Exception e) {
            map.put("status","error");
            map.put("message", e);
            return  map;
        }
    }
    @RequestMapping("/addPic")
    @ResponseBody
    //处理文件上传
    public Object uploadPic(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String filePath = null;
        String ss = null;
        Map map=new HashMap();
        if (file.isEmpty()){
            map.put("status","error");
            map.put("message", Message.NULLPIC);
            return map;
        }
        if (file.getSize()>picMax){
            map.put("status","error");
            map.put("message", Message.PICMAX);
            return map;
        }
        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(fileName.lastIndexOf("."));
        String[] str={".bmp",".jpg",".png",".tiff",".gif",".pcx",".tga",".exif",".fpx",".svg",".psd",".cdr",".pcd",".dxf",".ufo",".eps",".ai",".raw",".WMF",".webp"};
        if (!Arrays.asList(str).contains(fileName)){
            map.put("status","error");
            map.put("message", Message.PICTYPE);
            return map;
        }

        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(path);

            if (!path.exists()) {
                path = new File("");
            }
//如果上传目录为/static/images/upload/，则可以如下获取：
            File load = new File(path.getAbsolutePath(), "static/images/upload\\");
            if (!load.exists()) {
                load.mkdirs();
            }
            System.out.println("upload url:" + load.getAbsolutePath());
            filePath = load.getAbsolutePath();
            File targetFile = new File(load.getAbsolutePath());
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //格式化日期
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            fileName = format.format(new Date()) + fileName;

            ss = filePath + "/" + fileName;
            FileOutputStream out = new FileOutputStream(ss);
            out.write(file.getBytes());
            out.flush();
            out.close();
            map.put("status","success");
            map.put("message", fileName);
            return  map;
        } catch (Exception e) {
            map.put("status","error");
            map.put("message", e);
            return  map;
        }

    }

}
