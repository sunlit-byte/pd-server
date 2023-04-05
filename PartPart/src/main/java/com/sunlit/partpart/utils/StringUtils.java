package com.sunlit.partpart.utils;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 0:22
 **/
public class StringUtils {


    public static boolean isBlank(String s){

        if(s == null || s.length() == 0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isNotBlank(String s){
        return !isBlank(s);
    }
}
