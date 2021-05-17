package com.company.ielp.app.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.FollowMapper;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.entity.User;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;
    final FollowMapper followMapper;

    public UserServiceImpl(UserMapper userMapper, FollowMapper followMapper) {
        this.userMapper = userMapper;
        this.followMapper = followMapper;
    }

    @Override
    public UserDTO getUserById(int id) {
        UserDTO userDTO = new UserDTO();
        User user = userMapper.selectById(id);
        BeanUtils.copyProperties(user, userDTO);

        return userDTO;
    }

    @Override
    public UserDTO login(LoginParam loginParam) {
        UserDTO userDTO = new UserDTO();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        String accountNum = loginParam.getAccountNum();
        String passWord = loginParam.getPassWord();

        if (Validator.isEmail(accountNum)) {
            queryWrapper.eq("email", accountNum).eq("pass_word", passWord);
        } else if (Validator.isMobile(accountNum)) {
            queryWrapper.eq("phone_number", accountNum).eq("pass_word", passWord);
        } else {
            return null;
        }

        User user = userMapper.selectOne(queryWrapper);
        BeanUtils.copyProperties(user, userDTO);

        return userDTO;

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