package com.company.ielp.app.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * 为控制层提供用户信息封装
 * @author 幕冬
 */
@Data
public class UserInfoDTO {

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
