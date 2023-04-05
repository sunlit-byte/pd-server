package com.sunlit.partpart.controller;

import com.sunlit.partpart.base.BaseResp;
import com.sunlit.partpart.bean.ScoreReq;
import com.sunlit.partpart.bean.ScoreResp;
import com.sunlit.partpart.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:24
 **/
@RestController
@RequestMapping("/score")
@AllArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    //获取积分列表
    @RequestMapping("/list")
    public BaseResp list(){
        List<ScoreResp> res =  scoreService.list();
        return BaseResp.ok(res);
    }

    // 增加积分
    @RequestMapping("/operate")
    public BaseResp operateScore(@RequestBody ScoreReq req) throws Exception {
        scoreService.operateScore(req);
        return BaseResp.ok();
    }


}
