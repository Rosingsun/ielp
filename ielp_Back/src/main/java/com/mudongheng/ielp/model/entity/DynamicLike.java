package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
@Data
@TableName(value ="dynamic_like")
@EqualsAndHashCode(callSuper = true)
public class DynamicLike extends BaseEntity {

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

}