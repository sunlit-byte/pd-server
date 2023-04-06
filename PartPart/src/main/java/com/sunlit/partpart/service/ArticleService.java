package com.sunlit.partpart.service;

import com.sunlit.partpart.bean.ArticleInfoResp;
import com.sunlit.partpart.bean.ArticleReq;
import com.sunlit.partpart.bean.ArticleResp;

import java.io.IOException;
import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 21:26
 **/
public interface ArticleService {

    /**
     * @description: 获取文章缩略图列表
     * @author: Sunlit
     * @date: 2023/4/2 21:49  List<ArticleResp>
     **/
    List<ArticleResp> articleList();

    /**
     * @description: 获取文章详情
     * @author: Sunlit
     * @date: 2023/4/2 22:15
     * @param: articleId ArticleResp
     **/
    ArticleInfoResp getArticleInfoById(String articleId);

    void addArticle(ArticleReq articleReq) throws IOException;
}
