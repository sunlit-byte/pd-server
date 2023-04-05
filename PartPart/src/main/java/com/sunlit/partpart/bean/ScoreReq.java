package com.sunlit.partpart.bean;

import com.sunlit.partpart.constants.OperateType;
import com.sunlit.partpart.constants.ScoreType;
import lombok.Data;


/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 22:46
 **/

@Data
public class ScoreReq {

    //用户的id
    private String userId;

    //传递的积分
    private Integer score;

    //积分操作
    private OperateType operate;

    //积分来源
    private ScoreType type;
}
