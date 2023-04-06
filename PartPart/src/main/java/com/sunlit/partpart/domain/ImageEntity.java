package com.sunlit.partpart.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sunlit.partpart.base.BaseEntity;
import lombok.Data;

/**
 * @author Sunlit
 * @description
 * @date 2023-04-07 1:26
 **/
@Data
@TableName("image")
public class ImageEntity extends BaseEntity {

    private String imageId;

    private String image;
}
