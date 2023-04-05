package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunlit.partpart.base.BaseEntity;
import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 20:52
 **/
@Data
@TableName("article")
public class ArticleEntity extends BaseEntity {

    private String articleId;

    private String userId;

    private String articleName;

    private String articleIntroduce;
}
