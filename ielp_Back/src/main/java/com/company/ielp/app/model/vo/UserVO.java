package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.dto.UserInfoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends BaseVO {

    public UserVO() {
        super();
    }

    public UserVO(String msg, int state) {
        super.setMsg(msg);
        super.setState(state);
    }

    public UserVO(UserDTO user, String msg, int state) {
        this.user = user;
        super.setMsg(msg);
        super.setState(state);
    }

    public UserVO(UserInfoDTO userInfo, String msg, int state) {
        this.userInfo = userInfo;
        super.setMsg(msg);
        super.setState(state);
    }


    private UserDTO user;
    private UserInfoDTO userInfo;
    private boolean isLogin = false;
}
