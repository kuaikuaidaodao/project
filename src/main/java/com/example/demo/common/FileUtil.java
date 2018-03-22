package com.example.demo.common;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author li
 * @create 2018-03-21 14:28
 * @desc
 **/
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
