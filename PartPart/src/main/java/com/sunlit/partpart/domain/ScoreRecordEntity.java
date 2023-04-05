package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunlit.partpart.base.BaseEntity;
import com.sunlit.partpart.constants.OperateType;
import com.sunlit.partpart.constants.ScoreType;
import lombok.Data;


/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:15
 **/
@Data
@TableName("score_record")
public class ScoreRecordEntity extends BaseEntity {

    private String userId;

    private Integer score;

    private OperateType operate;

    private ScoreType type;
}
