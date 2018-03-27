package com.example.demo.common;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * @author li
 * @create 2018-03-26 17:02
 * @desc 公共类
 **/
public class Common {
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
