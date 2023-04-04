package com.sunlit.partpart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunlit.partpart.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-03 23:45
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
