package com.mudongheng.ielp.api.controller;

import com.mudongheng.ielp.api.exception.DynamicException;
import com.mudongheng.ielp.api.model.param.CommentParam;
import com.mudongheng.ielp.api.model.vo.DynamicVO;
import com.mudongheng.ielp.api.service.DynamicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
@Slf4j
@RestController
@RequestMapping("/api/dynamic")
public class DynamicController {

    private final DynamicService dynamicService;

    public DynamicController(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    private Integer getUserId(HttpServletRequest request) {
        return (Integer) request.getAttribute("userId");
    }

    @PostMapping("/get-dynamic-by-id")
    public DynamicVO getDynamicById(@RequestBody Integer id) throws DynamicException {
        log.info("获取id为：{} 的动态", id);
        return dynamicService.getDynamicById(id);
    }

    @PostMapping("/publish")
    public void publish(@RequestBody String dynamicInfo,
                        HttpServletRequest request) throws DynamicException {
        dynamicService.publish(this.getUserId(request), dynamicInfo);
    }

    @PostMapping("/un-publish")
    public void unPublish(@RequestBody Integer dynamicId,
                          HttpServletRequest request) throws DynamicException {
        dynamicService.unPublish(this.getUserId(request), dynamicId);
    }

    @PostMapping("/like")
    public void like(@RequestBody Integer dynamicId,
                     HttpServletRequest request) throws DynamicException {
        dynamicService.like(this.getUserId(request), dynamicId);
    }

    @PostMapping("/comment")
    public void comment(@RequestBody CommentParam commentParam,
                        HttpServletRequest request) throws DynamicException {
        dynamicService.comment(this.getUserId(request), commentParam.getDynamicId(), commentParam.getComment());
    }

    @PostMapping("/un-comment")
    public void unComment(@RequestBody Integer dynamicCommentId) throws DynamicException {
        dynamicService.unComment(dynamicCommentId);
    }

    @PostMapping("/collect")
    public void collect(@RequestBody Integer dynamicId,
                        HttpServletRequest request) throws DynamicException {
        dynamicService.collect(this.getUserId(request), dynamicId);
    }
    
}
