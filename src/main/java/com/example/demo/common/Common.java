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
    public static void main(String args[]) {

        System.out.println(chatName());
    }
    public static String chatName(){
        String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb=new StringBuffer();
        char[] rands = new char[6];
        for (int i = 0; i < rands.length; i++)
        {
            int rand = (int) (Math.random() * a.length());
            rands[i] = a.charAt(rand);
        }
        for(int i=0;i<rands.length;i++){
            sb.append(rands[i]);
        }
        return  sb.toString();
    }
}
