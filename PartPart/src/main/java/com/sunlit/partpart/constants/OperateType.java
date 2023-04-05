package com.sunlit.partpart.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-04 21:17
 **/
@AllArgsConstructor
@Getter
public enum OperateType {

    UP("UP","增加"),
    DOWN("DOWN","减少");


    private String code;

    private String displayName;
}
