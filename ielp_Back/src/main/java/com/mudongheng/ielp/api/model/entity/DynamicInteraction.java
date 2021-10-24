package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="dynamic_interaction")
@EqualsAndHashCode(callSuper = true)
public class DynamicInteraction extends BaseEntity {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 是否点赞
     */
    private Byte isLike;

    /**
     * 是否评论
     */
    private Byte isComment;

    /**
     * 是否收藏
     */
    private Byte isCollect;

    /**
     * 评论内容
     */
    private String commentInfo;

}