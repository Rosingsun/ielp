package com.company.ielp.app.service.impl;

import cn.hutool.core.lang.Validator;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.model.User;
import com.company.ielp.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Boolean login(String accNumber, String passWord) {
        User user = userMapper.login(accNumber, passWord);
        return user != null;
    }

    @Override
    public Boolean beUsed(String accNumber) {
        User user = userMapper.beUsed(accNumber);
        return user != null;
    }

    @Override
    public void register(String accNumber, String passWord) {
        User user = new User();
        if (Validator.isEmail(accNumber)) {
            user.setEmail(accNumber);
        } else if (Validator.isMobile(accNumber)) {
            user.setPhoneNumber(accNumber);
        } else {
            System.out.println("注册失败，账号格式出错！");
            return;
        }
        user.setId(userMapper.lastId() + 1);
        user.setPassWord(passWord);
        userMapper.insert(user);
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int addClockInContinuity(int id) {
        User user = userMapper.selectById(id);
        user.setClockInContinuity(user.getClockInContinuity() + 1);
        return userMapper.updateById(user);
    }

    @Override
    public int clearClockInContinuity(int id) {
        User user = userMapper.selectById(id);
        user.setClockInContinuity(0);
        return userMapper.updateById(user);
    }

    @Override
    public int addClockInTotal(int id) {
        User user = userMapper.selectById(id);
        user.setClockInTotal(user.getClockInTotal() + 1);
        return userMapper.updateById(user);
    }

    @Override
    public int addStudyTime(int id) {
        User user = userMapper.selectById(id);
        user.setStudyTime(user.getStudyTime() + 1);
        return userMapper.updateById(user);
    }

    @Override
    public int addIdentifyImg(int id) {
        User user = userMapper.selectById(id);
        user.setIdentifyImg(user.getIdentifyImg() + 1);
        return userMapper.updateById(user);
    }
}