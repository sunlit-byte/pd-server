package com.sunlit.partpart.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:19
 **/
@AllArgsConstructor
@Getter
public enum ScoreType {

    ARTICLE("ARTICLE","发布文章"),
    GAME("GAME","游戏"),
    SEARCH("SEARCH","搜索");



    private String code;

    private String displayName;
}
