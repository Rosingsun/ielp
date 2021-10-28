package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="user_follow")
@EqualsAndHashCode(callSuper = true)
public class UserFollow extends BaseEntity {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 关注用户id
     */
    private Integer followUserId;

}