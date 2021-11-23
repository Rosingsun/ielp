package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mudongheng.ielp.model.enums.DynamicTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="dynamic")
@EqualsAndHashCode(callSuper = true)
public class Dynamic extends BaseEntity {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 图文消息，翻译分享
     */
    private DynamicTypeEnum type;

    /**
     * 动态信息
     */
    private String info;

    /**
     * 相关文章
     */
    private String relatedArticles;

    /**
     * 翻译记录id
     */
    private Integer translateHistoryId;

    /**
     * 图片数量
     */
    private Integer imageNum;

    /**
     * 点赞数量
     */
    @TableField("`like`")
    private Integer like;

    /**
     * 评论
     */
    @TableField("`comment`")
    private Integer comment;

    /**
     * 收藏
     */
    private Integer collect;

}