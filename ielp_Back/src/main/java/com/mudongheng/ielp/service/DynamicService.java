package com.mudongheng.ielp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.exception.DynamicException;
import com.mudongheng.ielp.model.entity.Dynamic;
import com.mudongheng.ielp.model.vo.DynamicVO;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface DynamicService extends IService<Dynamic> {

    DynamicVO getDynamicById(Integer id) throws DynamicException;

    void publish(Integer userId, String dynamicInfo) throws DynamicException;

    void unPublish(Integer userId, Integer dynamicId) throws DynamicException;

    void like(Integer userId, Integer dynamicId) throws DynamicException;

    void comment(Integer userId, Integer dynamicId, String comment) throws DynamicException;

    void unComment(Integer dynamicCommentId) throws DynamicException;

    void collect(Integer userId, Integer dynamicId) throws DynamicException;

}
