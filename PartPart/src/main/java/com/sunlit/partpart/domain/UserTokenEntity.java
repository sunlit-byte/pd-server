package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sunlit.partpart.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:42
 **/
@Data
@TableName("user_token")
public class UserTokenEntity extends BaseEntity {

    private String userId;

    private String token;

    @JsonFormat(pattern = "yyyy-MM-dd:HH-mm-ss")
    private Date expireTime;


}
