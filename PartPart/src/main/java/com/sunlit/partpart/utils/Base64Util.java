package com.sunlit.partpart.utils;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.Base64;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-07 0:49
 **/
public class Base64Util {


    public static String encode(byte[] imageData){
        return Base64.getEncoder().encodeToString(imageData);
    }

    public static byte[] decode(String imageStr){
        return Base64.getDecoder().decode(imageStr);
    }
}
