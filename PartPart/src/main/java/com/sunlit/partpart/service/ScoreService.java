package com.sunlit.partpart.service;

import com.sunlit.partpart.bean.ScoreReq;
import com.sunlit.partpart.bean.ScoreResp;

import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:23
 **/
public interface ScoreService {

    /**
     * @description: 返回积分榜前20的列表
     * @author: Sunlit
     * @date: 2023/4/4 22:38  List<ScoreResp>
     **/
    List<ScoreResp> list();

    /**
     * @description: 操作积分
     * @author: Sunlit
     * @date: 2023/4/4 22:50
     * @param: req void
     **/
    void operateScore(ScoreReq req) throws Exception;
}
