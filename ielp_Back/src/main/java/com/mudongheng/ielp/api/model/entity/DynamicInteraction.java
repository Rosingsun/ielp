package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    private Boolean isLike;

    /**
     * 是否评论
     */
    private Boolean isComment;

    /**
     * 是否收藏
     */
    private Boolean isCollect;

    /**
     * 评论内容
     */
    private String commentInfo;

}