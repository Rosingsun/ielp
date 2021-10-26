package com.mudongheng.ielp.api.service;

import com.mudongheng.ielp.api.exception.UserException;
import com.mudongheng.ielp.api.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.api.model.param.LoginParam;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface UserService extends IService<User> {

    String login(LoginParam loginParam) throws UserException;

    String register(LoginParam loginParam);

}