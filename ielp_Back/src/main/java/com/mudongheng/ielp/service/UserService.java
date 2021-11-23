package com.mudongheng.ielp.service;

import com.mudongheng.ielp.exception.UserException;
import com.mudongheng.ielp.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mudongheng.ielp.model.param.LoginParam;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
public interface UserService extends IService<User> {

    String login(LoginParam loginParam) throws UserException;

    String register(LoginParam loginParam) throws UserException;

}