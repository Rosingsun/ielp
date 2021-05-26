package com.company.ielp.app.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.UserInfoMapper;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.mapper.UserRelationMapper;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.dto.UserInfoDTO;
import com.company.ielp.app.model.entity.User;
import com.company.ielp.app.model.entity.UserInfo;
import com.company.ielp.app.model.entity.UserRelation;
import com.company.ielp.app.model.params.FollowParam;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.params.RegisterParam;
import com.company.ielp.app.service.UserService;
import com.company.ielp.app.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    final String LOGIN_FAIL = "登陆失败，账号密码错误！";

    final UserMapper userMapper;
    final UserInfoMapper userInfoMapper;
    final UserRelationMapper userRelationMapper;

    public UserServiceImpl(UserMapper userMapper, UserInfoMapper userInfoMapper, UserRelationMapper userRelationMapper) {
        this.userMapper = userMapper;
        this.userInfoMapper = userInfoMapper;
        this.userRelationMapper = userRelationMapper;
    }

    private List<UserInfoDTO> toUserDTOList(List<UserInfo> users) {
        List<UserInfoDTO> list = new ArrayList<>();
        // 在对付大数据的时候这个真的有必要吗？
        // 值得考虑
        for (UserInfo u : users) {
            UserInfoDTO dto;
            BeanUtils.copyProperties(u, dto = new UserInfoDTO());
            list.add(dto);
        }
        return list;
    }

    /**
     * 获取用户id
     * @param userId 用户id
     * @return 用户信息
     */
    private UserDTO getUserById(int userId) {
        // 获取
        User user = userMapper.selectById(userId);
        // 转换
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        // 返回
        return userDTO;
    }

    /**
     * 获取用户id
     * @param userId 用户id
     * @return 用户信息
     */
    private UserInfoDTO getUserInfoById(int userId) {
        // 获取
        UserInfo userInfo = userInfoMapper.selectById(userId);
        // 转换
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo, userInfoDTO);
        // 返回
        return userInfoDTO;
    }

    @Override
    public String login(LoginParam loginParam) {
        // 验证信息
        String accountNum = loginParam.getAccountNum();
        String passWord = loginParam.getPassWord();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (Validator.isEmail(accountNum)) {
            queryWrapper.eq("email", accountNum).eq("pass_word", passWord);
        } else if (Validator.isMobile(accountNum)) {
            queryWrapper.eq("phone_number", accountNum).eq("pass_word", passWord);
        } else {
            return null;
        }

        User user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            return JwtUtil.createToken(user.getId());
        } else {
            // 这里还可以继续多样化
            log.info("用户：{} 尝试登陆失败", loginParam.getAccountNum());
            return null;
        }
    }

    @Override
    public void register(RegisterParam registerParam) {
        // 构建
        User user = new User();
        UserInfo userInfo = new UserInfo();

        user.setEmail(registerParam.getEmail());
        user.setPhoneNumber(registerParam.getPhoneNumber());
        user.setPassWord(registerParam.getPassWord());

        // 插入
        userMapper.insert(user);

        // 获取id，构建信息
        userInfo.setUserId(user.getId());
        userInfo.setNickName(registerParam.getNickName());

        // 插入
        userInfoMapper.insert(userInfo);
    }

    @Override
    public UserDTO getUser(String token) {
        int userId;
        try {
            userId = JwtUtil.getAudience(token);
        } catch (RuntimeException e) {
            return null;
        }
        return this.getUserById(userId);
    }

    @Override
    public UserInfoDTO getUserInfo(String token) {
        int userId;
        try {
            userId = JwtUtil.getAudience(token);
        } catch (RuntimeException e) {
            return null;
        }
        return this.getUserInfoById(userId);
    }

    @Override
    public String follow(FollowParam followParam) {
        UserRelation userRelation = new UserRelation();

        userRelation.setUserId(followParam.getUserId());
        userRelation.setTargetUserId(followParam.getTargetUserId());

        try {
            userRelationMapper.insert(userRelation);
        } catch (Exception e) {
            return "关注失败！";
        }

        return "关注成功！";
    }

    @Override
    public String unfollow(FollowParam followParam) {
        QueryWrapper<UserRelation> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("u1", followParam.getUserId()).eq("u2", followParam.getTargetUserId());

        try {
            userRelationMapper.delete(queryWrapper);
        } catch (Exception e) {
            return "取关失败！";
        }
        return "取关成功！";
    }

    @Override
    public List<UserInfoDTO> getAllFollows(int id) {
        QueryWrapper<UserRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);

        List<UserRelation> userRelationList = userRelationMapper.selectList(queryWrapper);

        List<UserInfo> userInfos = new ArrayList<>();

        QueryWrapper<UserInfo> queryWrapper2 = new QueryWrapper<>();
        for (UserRelation u : userRelationList) {
            queryWrapper2.eq("user_id", u.getTargetUserId());
            userInfos.add(userInfoMapper.selectOne(queryWrapper2));
            queryWrapper2.clear();
        }

        return toUserDTOList(userInfos);
    }

    @Override
    public List<UserInfoDTO> getAllFollowers(int id) {
        QueryWrapper<UserRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("target_user_id", id);

        List<UserRelation> userRelationList = userRelationMapper.selectList(queryWrapper);
        List<UserInfo> userInfos = new ArrayList<>();

        QueryWrapper<UserInfo> queryWrapper2 = new QueryWrapper<>();
        for (UserRelation u : userRelationList) {
            queryWrapper2.eq("user_id", u.getUserId());
            userInfos.add(userInfoMapper.selectOne(queryWrapper2));
            queryWrapper2.clear();
        }

        return toUserDTOList(userInfos);
    }
}