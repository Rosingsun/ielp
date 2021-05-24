package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.dto.UserInfoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends BaseVO {
    private UserDTO user;
    private UserInfoDTO userInfo;
    private String token;
    private boolean isLogin = false;
}
