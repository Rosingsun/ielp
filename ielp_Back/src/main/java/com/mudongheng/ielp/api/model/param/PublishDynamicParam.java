package com.mudongheng.ielp.api.model.param;

import lombok.Data;

/**
 * @author 幕冬
 * @since 2021年10月25日
 */
@Data
public class PublishDynamicParam {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 动态信息
     */
    private String info;

}
