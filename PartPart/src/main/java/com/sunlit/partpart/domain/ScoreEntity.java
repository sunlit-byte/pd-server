package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunlit.partpart.base.BaseEntity;
import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:14
 **/
@Data
@TableName("score")
public class ScoreEntity extends BaseEntity {

    private String userId;

    private Integer score;
}
