package com.mudongheng.ielp.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mudongheng.ielp.api.exception.DynamicException;
import com.mudongheng.ielp.api.mapper.DynamicCollectMapper;
import com.mudongheng.ielp.api.mapper.DynamicCommentMapper;
import com.mudongheng.ielp.api.mapper.DynamicLikeMapper;
import com.mudongheng.ielp.api.model.entity.Dynamic;
import com.mudongheng.ielp.api.mapper.DynamicMapper;
import com.mudongheng.ielp.api.model.entity.DynamicCollect;
import com.mudongheng.ielp.api.model.entity.DynamicComment;
import com.mudongheng.ielp.api.model.entity.DynamicLike;
import com.mudongheng.ielp.api.model.param.CommentParam;
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

    private final DynamicLikeMapper dynamicLikeMapper;

    private final DynamicCommentMapper dynamicCommentMapper;

    private final DynamicCollectMapper dynamicCollectMapper;

    public DynamicServiceImpl(DynamicLikeMapper dynamicLikeMapper, DynamicCommentMapper dynamicCommentMapper, DynamicCollectMapper dynamicCollectMapper) {
        this.dynamicLikeMapper = dynamicLikeMapper;
        this.dynamicCommentMapper = dynamicCommentMapper;
        this.dynamicCollectMapper = dynamicCollectMapper;
    }

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

    @Override
    public void like(Integer userId, Integer dynamicId) throws DynamicException {

        if (this.getById(dynamicId) == null) {
            throw new DynamicException("动态不存在");
        }

        DynamicLike dynamicLike = dynamicLikeMapper.selectOne(new QueryWrapper<DynamicLike>().eq("user_id", userId).eq("dynamic_id", dynamicId));

        // 点在不存在则创建，已存在则反转状态
        if (dynamicLike == null) {
            dynamicLike = new DynamicLike();
            dynamicLike.setUserId(userId);
            dynamicLike.setDynamicId(dynamicId);
            dynamicLike.setIsLike(true);
        } else {
            dynamicLike.setIsLike(!dynamicLike.getIsLike());
        }
        dynamicLikeMapper.insert(dynamicLike);

    }

    @Override
    public void comment(CommentParam commentParam) throws DynamicException {

        if (this.getById(commentParam.getDynamicId()) == null) {
            throw new DynamicException("动态不存在");
        }

        DynamicComment dynamicComment = new DynamicComment();
        dynamicComment.setUserId(commentParam.getUserId());
        dynamicComment.setDynamicId(commentParam.getDynamicId());
        dynamicComment.setComment(commentParam.getComment());
        dynamicComment.setIsComment(true);

        dynamicCommentMapper.insert(dynamicComment);
    }

    @Override
    public void unComment(Integer dynamicCommentId) throws DynamicException {
        if (dynamicCommentMapper.deleteById(dynamicCommentId) == 0) {
            throw new DynamicException("动态不存在");
        }
    }

    @Override
    public void collect(Integer userId, Integer dynamicId) throws DynamicException {
        if (this.getById(dynamicId) == null) {
            throw new DynamicException("动态不存在");
        }

        DynamicCollect dynamicCollect = dynamicCollectMapper.selectOne(new QueryWrapper<DynamicCollect>().eq("user_id", userId).eq("dynamic_id", dynamicId));

        // 收藏不存在则创建，已存在则反转状态
        if (dynamicCollect == null) {
            dynamicCollect = new DynamicCollect();
            dynamicCollect.setUserId(userId);
            dynamicCollect.setDynamicId(dynamicId);
            dynamicCollect.setIsCollect(true);
        } else {
            dynamicCollect.setIsCollect(!dynamicCollect.getIsCollect());
        }
        dynamicCollectMapper.insert(dynamicCollect);
    }
}




