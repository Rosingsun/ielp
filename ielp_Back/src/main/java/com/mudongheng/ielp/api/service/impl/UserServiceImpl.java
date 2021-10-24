package com.mudongheng.ielp.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mudongheng.ielp.api.model.entity.User;
import com.mudongheng.ielp.api.mapper.UserMapper;
import com.mudongheng.ielp.api.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}




