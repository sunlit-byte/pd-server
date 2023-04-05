package com.sunlit.partpart.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 22:06
 **/
@Data
public class ArticleInfoResp {
    private String articleId;

    private String userId;

    private String articleName;

    private String articleContent;

    private String imageId;

}
