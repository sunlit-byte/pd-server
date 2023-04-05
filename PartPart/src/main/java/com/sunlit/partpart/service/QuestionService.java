package com.sunlit.partpart.service;

import com.sunlit.partpart.domain.QuestionEntity;

import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-05 3:19
 **/
public interface QuestionService {

    /**
     * @description: 获取问题列表
     * @author: Sunlit
     * @date: 2023/4/5 3:25  List<QuestionEntity>
     **/
    List<QuestionEntity> getQuestionList();
}
