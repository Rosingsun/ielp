package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
     * 动态信息
     */
    private String info;

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