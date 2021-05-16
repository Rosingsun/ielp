package com.company.ielp.app.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 这一层可能不太会被用到
 * 但先存放着
 */
@Data
@ToString
public class UserDTO {

    private Integer id;

    private String nickName;

    private String profile;

    private String email;

    private String phoneNumber;

    private String sex;

    private Date birthday;

    private Integer clockInContinuity;

    private Integer clockInTotal;

    private Integer studyTime;

    private Integer identifyImg;

    private Date createTime;

    private Date updateTime;

}