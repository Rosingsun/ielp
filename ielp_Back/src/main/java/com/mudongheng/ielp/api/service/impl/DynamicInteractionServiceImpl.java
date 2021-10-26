package com.mudongheng.ielp.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mudongheng.ielp.api.model.entity.DynamicInteraction;
import com.mudongheng.ielp.api.mapper.DynamicInteractionMapper;
import com.mudongheng.ielp.api.model.param.CommentParam;
import com.mudongheng.ielp.api.service.DynamicInteractionService;
import org.springframework.stereotype.Service;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Service
public class DynamicInteractionServiceImpl extends ServiceImpl<DynamicInteractionMapper, DynamicInteraction> implements DynamicInteractionService {

    private DynamicInteraction getDynamicInteraction(Integer userId, Integer dynamicId) {
        return this.getOne(new QueryWrapper<DynamicInteraction>()
                .eq("user_id", userId)
                .eq("dynamic_id", dynamicId));
    }

    @Override
    public void like(Integer userId, Integer dynamicId) {
        DynamicInteraction dynamicInteraction = getDynamicInteraction(userId, dynamicId);
        // 之前无互动，添加互动内容
        if (dynamicInteraction == null) {

        }
        // 
    }

    @Override
    public String comment(Integer userId, CommentParam commentParam) {
        return null;
    }

    @Override
    public String collectDynamic(Integer userId, Integer dynamicId) {
        return null;
    }

}




