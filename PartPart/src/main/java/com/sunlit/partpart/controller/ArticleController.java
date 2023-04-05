package com.sunlit.partpart.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sunlit.partpart.base.BaseResp;
import com.sunlit.partpart.bean.ArticleInfoResp;
import com.sunlit.partpart.bean.ArticleReq;
import com.sunlit.partpart.bean.ArticleResp;
import com.sunlit.partpart.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 21:30
 **/
@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    @RequestMapping("/list")
    public BaseResp list(){
        List<ArticleResp> res =  articleService.articleList();
        return BaseResp.ok(res);
    }

    @RequestMapping("/info")
    public BaseResp info(@RequestBody ArticleReq articleReq){
        ArticleInfoResp res = articleService.getArticleInfoById(articleReq.getArticleId());
        return BaseResp.ok(res);
    }

    @RequestMapping("/save")
    public BaseResp save(@RequestBody ArticleReq articleReq){
        articleService.addArticle(articleReq);
        return BaseResp.ok();
    }


}
