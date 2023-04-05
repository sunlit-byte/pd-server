package com.sunlit.partpart.bean;

import com.sunlit.partpart.constants.OperateType;
import com.sunlit.partpart.constants.ScoreType;
import com.sunlit.partpart.domain.UserEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 22:34
 **/
@Data
public class ScoreResp {

    private UserEntity user;

    private Integer score;

    private OperateType operate;

    private ScoreType type;

    private Date createTime;
}
