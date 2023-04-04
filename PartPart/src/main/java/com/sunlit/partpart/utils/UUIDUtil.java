package com.sunlit.partpart.utils;

import java.util.UUID;

/**
 * @author Sunlit
 * @description 生成uuid
 * @date 2023-04-02 19:46
 **/
public class UUIDUtil {


    /**
     * @description: 获取uuid
     * @author: Sunlit
     * @date: 2023/4/2 19:48  String
     **/
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
