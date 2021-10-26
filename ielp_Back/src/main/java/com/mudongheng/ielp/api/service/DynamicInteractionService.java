package com.mudongheng.ielp.api.service;

import com.mudongheng.ielp.api.model.entity.DynamicInteraction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.api.model.param.CommentParam;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface DynamicInteractionService extends IService<DynamicInteraction> {

    void like(Integer userId, Integer dynamicId);

    String comment(Integer userId, CommentParam commentParam);

    String collectDynamic(Integer userId, Integer dynamicId);

}
