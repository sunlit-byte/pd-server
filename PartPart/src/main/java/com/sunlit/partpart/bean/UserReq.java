package com.sunlit.partpart.bean;

import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:54
 **/
@Data
public class UserReq {

    private String userId;

    private String userName;

    private String phone;

    private String password;

    private String imageId;
}
