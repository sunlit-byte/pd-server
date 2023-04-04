package com.sunlit.partpart.base;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sunlit
 * @description mybatisplus 基础类
 * @date 2023-04-02 18:50
 **/
@Data
public class BaseEntity implements Serializable {

    private static final Long serialVersionUID = 1l;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd:HH-mm-ss")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd:HH-mm-ss")
    private Date updateTime;

    @TableLogic
    private Integer deleteFlag;




}
