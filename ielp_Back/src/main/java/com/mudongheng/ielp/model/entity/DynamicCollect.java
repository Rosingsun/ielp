package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
@Data
@TableName(value ="dynamic_collect")
@EqualsAndHashCode(callSuper = true)
public class DynamicCollect extends BaseEntity {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 是否收藏
     */
    private Boolean isCollect;

}