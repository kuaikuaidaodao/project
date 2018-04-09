package com.example.demo.common;

/**
 * @author li
 * @create 2018-03-26 17:02
 * @desc 公共类
 **/
public class Common {
    public static boolean isNotNull(String string){
        if (null==string||"".equals(string)){
            return false;
        }
        return true;
    }
}
