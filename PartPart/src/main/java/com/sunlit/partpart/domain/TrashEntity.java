package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-06 13:49
 **/
@Data
@TableName("trash")
public class TrashEntity {

    private String classId;

    private String trashName;
}
