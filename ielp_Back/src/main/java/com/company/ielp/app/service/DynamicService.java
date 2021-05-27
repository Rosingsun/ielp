package com.company.ielp.app.service;

import com.company.ielp.app.model.dto.DynamicDTO;
import com.company.ielp.app.model.entity.Dynamic;
import com.company.ielp.app.model.entity.DynamicInteraction;
import com.company.ielp.app.model.params.DynamicInteractionParam;
import com.company.ielp.app.model.params.DynamicParam;

import java.util.List;

/**
 * 为社交服务提供数据处理
 * @author 幕冬
 */
public interface DynamicService {

    /**
     * 发表动态
     * @param dynamicParam 动态表单
     * @return 动态内容
     */
    Dynamic publishDynamic(DynamicParam dynamicParam);

    /**
     * 进行互动
     * @param dynamicInteractionParam 互动表单
     * @return 互动信息
     */
    DynamicInteraction publishInteraction(DynamicInteractionParam dynamicInteractionParam);

    /**
     * 获取用户动态
     * @param userId 用户id
     * @return 动态列表
     */
    List<DynamicDTO> getUserDynamic(int userId);


}