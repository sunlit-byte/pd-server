package com.sunlit.partpart.service;

import com.sunlit.partpart.base.BaseResp;
import com.sunlit.partpart.bean.UserReq;
import com.sunlit.partpart.domain.UserEntity;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:47
 **/
public interface UserService {

    /**
     * @description:  注册新用户
     * @author: Sunlit
     * @date: 2023/4/4 0:01
     * @param: req void
     **/
    BaseResp register(UserReq req);

    /**
     * @description: 修改名称 头像 密码；
     * @author: Sunlit
     * @date: 2023/4/4 0:20
     * @param: req void
     **/
    void edit(UserReq req);

    /**
     * @description: 登录
     * @author: Sunlit
     * @date: 2023/4/4 0:40
     * @param: req String
     **/
    String login(UserReq req);

    /**
     * @description: 获取信息
     * @author: Sunlit
     * @date: 2023/4/4 0:48
     * @param: req UserEntity
     **/
    UserEntity info(UserReq req);
}
