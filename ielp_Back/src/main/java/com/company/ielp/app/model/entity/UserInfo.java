package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * 用户详情信息
 * @author 幕冬儿
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String nickName;
    private String profile;
    private String sex;
    private Date birthday;
    private Integer clockInContinuity;
    private Integer clockInTotal;
    private Integer studyTime;
    private Integer identifyImg;
    private Integer userId;

}
