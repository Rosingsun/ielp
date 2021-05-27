package com.company.ielp.app.controller;


import com.company.ielp.app.model.dto.DynamicDTO;
import com.company.ielp.app.model.params.DynamicInteractionParam;
import com.company.ielp.app.model.params.DynamicParam;
import com.company.ielp.app.model.vo.BaseVO;
import com.company.ielp.app.model.vo.DynamicInteractionVO;
import com.company.ielp.app.model.vo.DynamicVO;
import com.company.ielp.app.service.DynamicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

/**
 * 提供动态方案
 * @author 幕冬
 * @see DynamicService
 */
@Slf4j
@Controller
@RequestMapping("/dynamic")
public class DynamicController {

    final String GET_SUCCESS = "获取成功！";

    final DynamicService dynamicService;

    public DynamicController(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    /**
     * 发表动态
     * @param dynamicParam 内容表单
     * @return 记录列表
     */
    @GetMapping("/publish-dynamic")
    @ResponseBody
    public DynamicVO publishDynamic(DynamicParam dynamicParam) {
        return new DynamicVO(
                Collections.singletonList(new DynamicDTO(dynamicService.publishDynamic(dynamicParam))),
                GET_SUCCESS,
                BaseVO.SUCCESS);
    }

    /**
     * 发表互动
     * @param dIP 互动表单
     * @return 记录列表
     */
    @GetMapping("/publish-interaction")
    @ResponseBody
    public DynamicInteractionVO publishInteraction(DynamicInteractionParam dIP) {
        return new DynamicInteractionVO(
                Collections.singletonList(dynamicService.publishInteraction(dIP)),
                GET_SUCCESS,
                BaseVO.SUCCESS);
    }

    /**
     * 获取用户动态
     * @param userId 用户id
     * @return 记录列表
     */
    @GetMapping("/get-dynamic")
    @ResponseBody
    public DynamicVO getUserDynamic(int userId) {
        return new DynamicVO(
                dynamicService.getUserDynamic(userId),
                GET_SUCCESS,
                BaseVO.SUCCESS);
    }



}
