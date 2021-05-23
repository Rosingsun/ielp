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
        DynamicInteraction dynamicInteraction = new DynamicInteraction();

        BeanUtils.copyProperties(dynamicInteractionParam, dynamicInteraction);

        Dynamic dynamic = dynamicMapper.selectById(dynamicInteractionParam.getDynamicId());

        if (dynamicInteractionParam.getIsLike()) {
            dynamic.addLike();
        }

        if (dynamicInteractionParam.getIsComment()) {
            dynamic.addComment();
        }

        dynamicInteractionMapper.insert(dynamicInteraction);
        dynamicMapper.updateById(dynamic);

        return dynamicInteraction;
    }

}
