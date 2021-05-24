package com.company.ielp.app.model.params;

import lombok.Data;

/**
 * 注册表单表单
 * @author 幕冬
 */
@Data
public class RegisterParam {

    private String nickName;
    private String sex;

    private String email;
    private String phoneNumber;
    private String passWord;



}
