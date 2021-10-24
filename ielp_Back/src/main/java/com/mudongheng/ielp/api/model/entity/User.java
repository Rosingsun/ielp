package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 用户头像
     */
    private String profile;

    /**
     * 性别
     */
    private Object sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 持续打卡时间
     */
    private Integer clockInContinuity;

    /**
     * 总共打卡时间
     */
    private Integer clockInTotal;

    /**
     * 学习时间
     */
    private Integer studyTime;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 识图总数
     */
    private Integer identifyImg;

}