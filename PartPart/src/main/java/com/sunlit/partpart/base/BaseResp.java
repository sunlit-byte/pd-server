package com.sunlit.partpart.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 21:34
 **/
@Data
@AllArgsConstructor
public class BaseResp {


    private Integer code;

    private String msg;

    private Object data;

    public static BaseResp ok(Object data){
        return new BaseResp(200,"获取成功",data);
    }

    public static BaseResp fail(){
        return new BaseResp(500,"未知错误",null);
    }

    public static BaseResp ok(){
        return new BaseResp(200,"获取成功",null);
    }

    public static BaseResp fail(String msg){
        return new BaseResp(500,msg,null);
    }

}
