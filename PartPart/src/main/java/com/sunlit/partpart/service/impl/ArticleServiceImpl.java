package com.sunlit.partpart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunlit.partpart.bean.ArticleInfoResp;
import com.sunlit.partpart.bean.ArticleReq;
import com.sunlit.partpart.bean.ArticleResp;
import com.sunlit.partpart.domain.ArticleEntity;
import com.sunlit.partpart.domain.ArticleInfoEntity;
import com.sunlit.partpart.mapper.ArticleInfoMapper;
import com.sunlit.partpart.mapper.ArticleMapper;
import com.sunlit.partpart.service.ArticleService;
import com.sunlit.partpart.utils.UUIDUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-02 21:29
 **/
@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    private final ArticleInfoMapper articleInfoMapper;


    /**
     * @description: 获取文章缩略图列表
     * @author: Sunlit
     * @date: 2023/4/2 21:49  List<ArticleResp>
     **/
    @Override
    public List<ArticleResp> articleList() {
        QueryWrapper<ArticleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time")
                .last("limit 0,20");
        List<ArticleEntity> articleEntities = articleMapper.selectList(queryWrapper);

        List<ArticleResp> resp = new ArrayList<>();
        for(ArticleEntity entity : articleEntities){
            resp.add(generateArticleResp(entity));
        }
        return resp;
    }

    /**
     * @param articleId
     * @description: 获取文章详情
     * @author: Sunlit
     * @date: 2023/4/2 22:15
     * @param: articleId ArticleResp
     */
    @Override
    public ArticleInfoResp getArticleInfoById(String articleId) {
        QueryWrapper<ArticleInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id",articleId);
        ArticleInfoEntity articleInfoEntity = articleInfoMapper.selectOne(wrapper);
        return generateArticleInfoResp(articleInfoEntity);
    }

    @Transactional
    @Override
    public void addArticle(ArticleReq articleReq) {
        String uuid = UUIDUtil.generateUUID();
        ArticleInfoEntity articleInfoEntity = new ArticleInfoEntity();
        articleInfoEntity.setArticleName(articleReq.getArticleName());
        articleInfoEntity.setArticleContent(articleReq.getArticleContent());
        articleInfoEntity.setUserId(articleInfoEntity.getUserId());
        articleInfoEntity.setImageId(null);
        articleInfoEntity.setArticleId(uuid);
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setArticleName(articleReq.getArticleName());
        articleEntity.setArticleIntroduce(articleReq.getArticleContent().substring(0,Math.min(15,articleReq.getArticleContent().length())));
        articleEntity.setArticleId(uuid);
        articleEntity.setUserId(articleEntity.getUserId());
        articleInfoMapper.insert(articleInfoEntity);
        articleMapper.insert(articleEntity);
    }


    private ArticleResp generateArticleResp(ArticleEntity entity){
        ArticleResp articleResp = new ArticleResp();
        articleResp.setUserId(entity.getUserId());
        articleResp.setArticleName(entity.getArticleName());
        articleResp.setArticleId(entity.getArticleId());
        articleResp.setArticleIntroduce(entity.getArticleIntroduce());
        articleResp.setArticleIcon(null);
        return articleResp;
    }
    private ArticleInfoResp generateArticleInfoResp(ArticleInfoEntity entity){
        ArticleInfoResp articleInfoResp = new ArticleInfoResp();
        articleInfoResp.setUserId(entity.getUserId());
        articleInfoResp.setArticleId(entity.getArticleId());
        articleInfoResp.setArticleContent(entity.getArticleContent());
        articleInfoResp.setArticleName(entity.getArticleName());
        articleInfoResp.setImageId(null);
        return articleInfoResp;
    }
}
