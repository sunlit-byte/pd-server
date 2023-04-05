package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunlit.partpart.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 20:54
 **/
@Data
@TableName("article_info")
public class ArticleInfoEntity extends BaseEntity {

    private String articleId;

    private String userId;

    private String articleName;

    private String articleContent;

    private String imageId;


}
