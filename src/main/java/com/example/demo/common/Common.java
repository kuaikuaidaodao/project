package com.example.demo.common;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author li
 * @create 2018-03-26 17:02
 * @desc 公共类
 **/
@RestController
@RequestMapping("common")
public class Common {
    @RequestMapping("picdelete")
    public void PicDelete(String url){
        if (url!=null){
            String[] str=url.split(",");
            if (str.length>0) {
                for (String s : str) {
                    deletePic(s);
                }
            }
        }
    }
    public void deletePic(String url){
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            File load = new File(path.getAbsolutePath(), "static/images/upload\\"+url);
            if (load.exists()) {
                boolean s=new File(load.getAbsolutePath()).delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("deletefile")
    public void deleteFile(String url){
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            File load = new File(path.getAbsolutePath(), "static/file/upload\\"+url);
            if (load.exists()) {
                boolean s=new File(load.getAbsolutePath()).delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
