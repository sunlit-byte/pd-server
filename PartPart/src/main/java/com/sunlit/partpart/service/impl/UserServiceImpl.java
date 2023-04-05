package com.sunlit.partpart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sunlit.partpart.bean.UserReq;
import com.sunlit.partpart.domain.UserEntity;
import com.sunlit.partpart.domain.UserTokenEntity;
import com.sunlit.partpart.mapper.UserMapper;
import com.sunlit.partpart.mapper.UserTokenMapper;
import com.sunlit.partpart.service.UserService;
import com.sunlit.partpart.utils.StringUtils;
import com.sunlit.partpart.utils.UUIDUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:47
 **/
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    private final UserTokenMapper userTokenMapper;


    /**
     * @param req
     * @description: 注册新用户
     * @author: Sunlit
     * @date: 2023/4/4 0:01
     * @param: req void
     */
    @Override
    @Transactional
    public void register(UserReq req) {
        //在user表中添加信息
        //在token表中添加信息
        String userId = UUIDUtil.generateUUID();
        String token = UUIDUtil.generateUUID();
        String userName = "user" + String.valueOf(System.currentTimeMillis()).substring(5);
        LocalDateTime expireTime = LocalDateTime.now().plusDays(30);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setUserName(userName);
        userEntity.setPhone(req.getPhone());
        userEntity.setPassword(req.getPassword());
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setUserId(userId);
        userTokenEntity.setToken(token);
        userTokenEntity.setExpireTime(Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()));
        userMapper.insert(userEntity);
        userTokenMapper.insert(userTokenEntity);
    }

    /**
     * @param req
     * @description: 修改名称 头像 密码；
     * @author: Sunlit
     * @date: 2023/4/4 0:20
     * @param: req void
     */
    @Override
    public void edit(UserReq req) {
        UserEntity userEntity = new UserEntity();
        if(StringUtils.isNotBlank(req.getUserName())){
            userEntity.setUserName(req.getUserName());
        }else if(StringUtils.isNotBlank(req.getImageId())){
            userEntity.setImageId(req.getImageId());
        }else if(StringUtils.isNotBlank(req.getPassword())){
            userEntity.setPassword(req.getPassword());
        }
        UpdateWrapper<UserEntity> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",req.getUserId());
        userMapper.update(userEntity,wrapper);
    }

    /**
     * @param req
     * @description: 登录
     * @author: Sunlit
     * @date: 2023/4/4 0:40
     * @param: req String
     */
    @Override
    public String login(UserReq req) {
        //根据phone进行查询
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("phone",req.getPhone());
        UserEntity userEntity = userMapper.selectOne(wrapper);
        if(userEntity == null || !userEntity.getPassword().equals(req.getPassword())){
            return null;
        }
        return userEntity.getUserId();
    }

    /**
     * @param req
     * @description: 获取信息
     * @author: Sunlit
     * @date: 2023/4/4 0:48
     * @param: req UserEntity
     */
    @Override
    public UserEntity info(UserReq req) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",req.getUserId());
        return userMapper.selectOne(wrapper);
    }
}
