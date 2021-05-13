package com.company.ielp.app.model;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 */
@Data
public class User {
    private Integer id;
    private String nickName;
    private String profile;
    private String email;
    private String phoneNumber;
    private String passWord;
    private String sex;
    private Date birthday;
    private Integer clockInContinuity;
    private Integer clockInTotal;
    private Integer studyTime;
    private Integer identifyImg;
}
