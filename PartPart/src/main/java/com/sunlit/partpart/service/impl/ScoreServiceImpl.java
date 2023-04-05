package com.sunlit.partpart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunlit.partpart.bean.ScoreReq;
import com.sunlit.partpart.bean.ScoreResp;
import com.sunlit.partpart.constants.OperateType;
import com.sunlit.partpart.domain.ScoreEntity;
import com.sunlit.partpart.domain.ScoreRecordEntity;
import com.sunlit.partpart.domain.UserEntity;
import com.sunlit.partpart.mapper.ScoreMapper;
import com.sunlit.partpart.mapper.ScoreRecordMapper;
import com.sunlit.partpart.mapper.UserMapper;
import com.sunlit.partpart.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:24
 **/
@Service
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;

    private final ScoreRecordMapper scoreRecordMapper;

    private final UserMapper userMapper;


    /**
     * @description: 返回积分榜前20的列表
     * @author: Sunlit
     * @date: 2023/4/4 22:38  List<ScoreResp>
     **/
    @Override
    public List<ScoreResp> list() {
        QueryWrapper<ScoreEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("score")
                .last("limit 0,20");
        List<ScoreEntity> scoreEntities = scoreMapper.selectList(wrapper);
        List<ScoreResp> res = new ArrayList<>();
        for(ScoreEntity entity : scoreEntities){
            ScoreResp scoreResp = new ScoreResp();
            scoreResp.setScore(entity.getScore());
            UserEntity userEntity = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_id", entity.getUserId()));
            scoreResp.setUser(userEntity);
            res.add(scoreResp);
        }
        return res;
    }

    /**
     * @param req
     * @description: 操作积分
     * @author: Sunlit
     * @date: 2023/4/4 22:50
     * @param: req void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void operateScore(ScoreReq req) throws Exception {
        //构造积分记录
        ScoreRecordEntity scoreRecordEntity = new ScoreRecordEntity();
        scoreRecordEntity.setUserId(req.getUserId());
        scoreRecordEntity.setOperate(req.getOperate());
        scoreRecordEntity.setType(req.getType());
        scoreRecordEntity.setScore(req.getScore());
        scoreRecordMapper.insert(scoreRecordEntity);
        ScoreEntity entity = scoreMapper.selectOne(new QueryWrapper<ScoreEntity>().eq("user_id", req.getUserId()));
        if(entity != null){
            if(req.getOperate() == OperateType.UP){
                entity.setScore(entity.getScore() + req.getScore());
            }else if(req.getOperate() == OperateType.DOWN){
                entity.setScore(entity.getScore() - req.getScore());
            }else {
                throw new Exception("ss");
            }
            scoreMapper.update(entity,new QueryWrapper<ScoreEntity>().eq("user_id",entity.getUserId()));
        }else {
            entity = new ScoreEntity();
            entity.setUserId(req.getUserId());
            entity.setScore(req.getScore());
            scoreMapper.insert(entity);
        }
    }
}
