package com.sunlit.partpart.bean;

import lombok.Data;

/**
 * @author Sunlit
 * @description 文章返回
 * @date 2023-04-02 21:33
 **/
@Data
public class ArticleResp {


    private String articleId;

    private String userId;

    private String articleName;

    private String articleIntroduce;

    private String articleIcon;

}
