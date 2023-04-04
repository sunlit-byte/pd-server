package com.sunlit.partpart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.sunlit.partpart.domain.ArticleInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 21:27
 **/
@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfoEntity> {
}
