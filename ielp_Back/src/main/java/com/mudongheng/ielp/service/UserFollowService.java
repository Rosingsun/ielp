package com.mudongheng.ielp.service;

import com.mudongheng.ielp.exception.FollowException;
import com.mudongheng.ielp.exception.UserException;
import com.mudongheng.ielp.model.entity.UserFollow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.model.param.FollowParam;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface UserFollowService extends IService<UserFollow> {

    void follow(FollowParam followParam) throws FollowException, UserException;

    void unfollow(FollowParam followParam) throws FollowException, UserException;

}
