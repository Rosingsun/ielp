package com.mudongheng.ielp.api.service;

import com.mudongheng.ielp.api.exception.FollowException;
import com.mudongheng.ielp.api.exception.UserException;
import com.mudongheng.ielp.api.model.entity.UserFollow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.api.model.param.FollowParam;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface UserFollowService extends IService<UserFollow> {

    void follow(FollowParam followParam) throws FollowException, UserException;

    void unfollow(FollowParam followParam) throws FollowException, UserException;

}
