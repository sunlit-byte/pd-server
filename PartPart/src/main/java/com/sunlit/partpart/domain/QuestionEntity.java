package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-05 3:14
 **/
@Data
@TableName("question")
public class QuestionEntity{

    private static final Long serialVersionUID = 1l;

    private Integer id;

    private String description;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    private String info;
}
