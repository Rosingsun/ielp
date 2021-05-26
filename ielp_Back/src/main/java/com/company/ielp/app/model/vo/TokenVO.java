package com.company.ielp.app.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包含token信息
 * @author 幕冬
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TokenVO extends BaseVO {

    public TokenVO() {
        super();
    }

    public TokenVO(String token, String msg, Integer state) {
        this.token = token;
        super.setMsg(msg);
        super.setState(state);
    }

    private String token;
}
