package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
@Data
@TableName(value ="dynamic_comment")
@EqualsAndHashCode(callSuper = true)
public class DynamicComment extends BaseEntity {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 是否评论
     */
    private Boolean isComment;
}