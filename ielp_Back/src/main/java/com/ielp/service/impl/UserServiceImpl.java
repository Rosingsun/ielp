package com.ielp.service.impl;

import com.ielp.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ielp.pojo.User;
import com.ielp.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public List<User> userList() {
        return userMapper.selectList(null);
    }
}
