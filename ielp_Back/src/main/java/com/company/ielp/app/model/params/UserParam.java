package com.company.ielp.app.model.params;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserParam {
    private String nickName;
    private String profile;
    private String email;
    private String phoneNumber;
    private String passWord;
    private String sex;
    private Date birthday;


    // 这部分是给用户输入的，用户经历避免输入以下内容
//    private Integer clockInContinuity;
//    private Integer clockInTotal;
//    private Integer studyTime;
//    private Integer identifyImg;
}
