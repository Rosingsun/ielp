package com.mudongheng.ielp.api.service;

import com.mudongheng.ielp.api.exception.DynamicException;
import com.mudongheng.ielp.api.model.entity.Dynamic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.api.model.param.CommentParam;
import com.mudongheng.ielp.api.model.param.PublishDynamicParam;
import com.mudongheng.ielp.api.model.param.UnPublishDynamicParam;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface DynamicService extends IService<Dynamic> {

    void publish(PublishDynamicParam publishDynamicParam) throws DynamicException;

    void unPublish(UnPublishDynamicParam unPublishDynamicParam) throws DynamicException;

    void like(Integer userId, Integer dynamicId) throws DynamicException;

    void comment(CommentParam commentParam) throws DynamicException;

    void unComment(Integer dynamicCommentId) throws DynamicException;

    void collect(Integer userId, Integer dynamicId) throws DynamicException;

}
