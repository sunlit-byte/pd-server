package com.sunlit.partpart.controller;

import com.sunlit.partpart.base.BaseResp;
import com.sunlit.partpart.domain.QuestionEntity;
import com.sunlit.partpart.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Sunlit
 * @description
 * @date 2023-04-05 3:21
 **/
@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    /**
     * @description:
     * @author: Sunlit
     * @date: 2023/4/5 3:23  List<QuestionEntity>
     **/
    @RequestMapping("/list")
    public BaseResp getQuestionList(){

        List<QuestionEntity> res = questionService.getQuestionList();
        return BaseResp.ok(res);
    }

}
