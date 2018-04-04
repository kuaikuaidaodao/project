package com.example.demo.common;

import org.springframework.context.i18n.LocaleContextHolder;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;

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
