package com.mudongheng.ielp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mudongheng.ielp.exception.FollowException;
import com.mudongheng.ielp.exception.UserException;
import com.mudongheng.ielp.mapper.UserMapper;
import com.mudongheng.ielp.model.entity.User;
import com.mudongheng.ielp.model.entity.UserFollow;
import com.mudongheng.ielp.mapper.UserFollowMapper;
import com.mudongheng.ielp.model.param.FollowParam;
import com.mudongheng.ielp.service.UserFollowService;
import org.springframework.stereotype.Service;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow> implements UserFollowService {

    private final UserMapper userMapper;

    public UserFollowServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void follow(FollowParam followParam) throws FollowException, UserException {
        // 获取第一个用户，第一个用户由token得出
        User user = userMapper.getUserNotNull(followParam.getUserId());
        // 获取第二个用户
        User followUser = userMapper.getUserNotNull(followParam.getFollowUserId());

        // 是否已关注
        UserFollow userFollow = this.getOne(new QueryWrapper<UserFollow>()
                .eq("user_id", user.getId())
                .eq("follow_user_id", followUser.getId()));

        if (userFollow != null) {
            throw new FollowException("已关注该用户");
        }

        userFollow = new UserFollow();
        userFollow.setUserId(user.getId());
        userFollow.setFollowUserId(followUser.getId());

        // 新增关注
        this.save(userFollow);
    }

    @Override
    public void unfollow(FollowParam followParam) throws FollowException, UserException {
        // 获取第一个用户，第一个用户由token得出
        User user = userMapper.getUserNotNull(followParam.getUserId());
        // 获取第二个用户
        User followUser = userMapper.getUserNotNull(followParam.getFollowUserId());

        // 是否未关注
        UserFollow userFollow = this.getOne(new QueryWrapper<UserFollow>()
                .eq("user_id", user.getId())
                .eq("follow_user_id", followUser.getId()));

        if (userFollow == null) {
            throw new FollowException("未关注该用户");
        }

        // 取消关注
        this.removeById(userFollow.getId());
    }
}




