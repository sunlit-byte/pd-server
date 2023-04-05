package com.sunlit.partpart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunlit.partpart.domain.QuestionEntity;
import com.sunlit.partpart.mapper.QuestionMapper;
import com.sunlit.partpart.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-05 3:20
 **/
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {


    private final QuestionMapper questionMapper;

    /**
     * @description: 获取问题列表
     * @author: Sunlit
     * @date: 2023/4/5 3:25  List<QuestionEntity>
     **/
    @Override
    public List<QuestionEntity> getQuestionList() {
        QueryWrapper<QuestionEntity> wrapper = new QueryWrapper<>();
        wrapper.last("order by rand() limit 10");
        return questionMapper.selectList(wrapper);
    }
}
