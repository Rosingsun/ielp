package com.company.ielp.app.service.impl;

import com.company.ielp.app.mapper.DynamicInteractionMapper;
import com.company.ielp.app.mapper.DynamicMapper;
import com.company.ielp.app.model.entity.Dynamic;
import com.company.ielp.app.model.entity.DynamicInteraction;
import com.company.ielp.app.model.params.DynamicInteractionParam;
import com.company.ielp.app.model.params.DynamicParam;
import com.company.ielp.app.service.DynamicService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl implements DynamicService {

    final DynamicMapper dynamicMapper;
    final DynamicInteractionMapper dynamicInteractionMapper;

    public DynamicServiceImpl(DynamicMapper dynamicMapper, DynamicInteractionMapper dynamicInteractionMapper) {
        this.dynamicMapper = dynamicMapper;
        this.dynamicInteractionMapper = dynamicInteractionMapper;
    }

    @Override
    public Dynamic publishDynamic(DynamicParam dynamicParam) {
        Dynamic dynamic = new Dynamic();

        BeanUtils.copyProperties(dynamicParam, dynamic);

        // 数据库的默认是不会影响到这里的，所以劲量不要使用此处返回的数据
        dynamicMapper.insert(dynamic);

        return dynamic;
    }

    @Override
    public DynamicInteraction publishInteraction(DynamicInteractionParam dynamicInteractionParam) {

        // 构建互动对象
        DynamicInteraction dynamicInteraction = new DynamicInteraction();
        BeanUtils.copyProperties(dynamicInteractionParam, dynamicInteraction);

        // 根据互动对象获取动态信息
        Dynamic dynamic = dynamicMapper.selectById(dynamicInteraction.getDynamicId());

        // 修改动态信息
        if (dynamicInteraction.getIsLike()) {
            dynamic.addLike();
        }

        if (dynamicInteraction.getIsComment()) {
            dynamic.addComment();
        }

        // 插入互动信息
        dynamicInteractionMapper.insert(dynamicInteraction);
        // 更新动态信息
        dynamicMapper.updateById(dynamic);

        return dynamicInteraction;
    }

}
