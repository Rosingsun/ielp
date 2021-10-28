package com.mudongheng.ielp.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mudongheng.ielp.api.exception.UserException;
import com.mudongheng.ielp.api.model.entity.User;
import com.mudongheng.ielp.api.mapper.UserMapper;
import com.mudongheng.ielp.api.model.param.LoginParam;
import com.mudongheng.ielp.api.service.UserService;
import com.mudongheng.ielp.api.util.JWTUtil;
import com.mudongheng.ielp.api.util.PasswordEncoderUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public String login(LoginParam loginParam) throws UserException {

        String username = loginParam.getUsername();
        String password = loginParam.getPassword();

        // 表单验证
        if (username.equals("") || password.equals("")) {
            throw new UserException("请输入账号密码");
        }

        User user = getOne(new QueryWrapper<User>().eq("username", username));

        // 用户不存在
        if (user == null) {
            throw new UserException("账号密码错误");
        }

        if (!PasswordEncoderUtil.matches(password, user.getPassword())) {
            throw new UserException("账号密码错误");
        }

        // 返回token
        return JWTUtil.sign(user);
    }

    @Override
    public String register(LoginParam loginParam) throws UserException {

        // 不得为空
        if (loginParam.getUsername().equals("") || loginParam.getPassword().equals("")) {
            throw new UserException("账号密码不得为空");
        }

        User user = new User();

        user.setUsername(loginParam.getUsername());

        String password = PasswordEncoderUtil.encode(loginParam.getPassword());

        user.setPassword(password);
        user.setBirthday(new Date());

        this.save(user);

        return JWTUtil.sign(user);
    }
}




