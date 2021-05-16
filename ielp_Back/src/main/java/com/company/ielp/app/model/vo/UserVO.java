package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends BaseVO {
    private UserDTO user;
    private boolean isLogin = false;
}
