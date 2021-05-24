package com.company.ielp.app.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 为控制层提供用户安全信息封装
 * 不想被前端看见密码
 * @author 幕冬
 */
@Data
@ToString
public class UserDTO {

    private Integer id;

    private String email;

    private String phoneNumber;

}