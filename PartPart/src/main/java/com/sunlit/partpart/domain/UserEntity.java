package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunlit.partpart.base.BaseEntity;
import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:41
 **/
@Data
@TableName("user")
public class UserEntity extends BaseEntity {

    private String userId;

    private String UserName;

    private String ImageId;

    private String phone;

    private String password;
}
