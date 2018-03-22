package com.example.demo.common;

/**
 * @author li
 * @create 2018-02-01 16:04
 * @desc dis
 **/
public class singole {
   private static singole singole;

    private singole() {
    }

    public static singole getSingole() {
        if (singole==null){
            singole=new singole();
        }
        return singole;
    }
}
