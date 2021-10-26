package com.mudongheng.ielp.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mudongheng.ielp.api.exception.DynamicException;
import com.mudongheng.ielp.api.model.entity.Dynamic;
import com.mudongheng.ielp.api.mapper.DynamicMapper;
import com.mudongheng.ielp.api.model.param.PublishDynamicParam;
import com.mudongheng.ielp.api.model.param.UnPublishDynamicParam;
import com.mudongheng.ielp.api.service.DynamicService;
import org.springframework.stereotype.Service;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Service
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicService {

    @Override
    public void publish(PublishDynamicParam publishDynamicParam) throws DynamicException {

        // 用户名由token给出，之后不再做用户不存在判断

        String info = publishDynamicParam.getInfo();
        if (info.equals("")) {
            throw new DynamicException("发布动态为空");
        }

        Dynamic dynamic = new Dynamic();

        dynamic.setInfo(info);
        dynamic.setUserId(publishDynamicParam.getUserId());

        this.save(dynamic);
    }

    @Override
    public void unPublish(UnPublishDynamicParam unPublishDynamicParam) throws DynamicException {
        if (!this.removeById(unPublishDynamicParam.getDynamicId())) {
            throw new DynamicException("动态不存在");
        }
    }
}




