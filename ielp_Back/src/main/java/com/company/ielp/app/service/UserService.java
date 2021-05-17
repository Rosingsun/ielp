package com.company.ielp.app.service;

import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.entity.User;
import com.company.ielp.app.model.params.FollowParam;
import com.company.ielp.app.model.params.LoginParam;

import java.util.List;

/**
 * 为用户提供相关服务
 * @author 幕冬儿
 * @see com.company.ielp.app.service.impl.UserServiceImpl
 */
public interface UserService {

    /**
     * 根据id获取成员
     * @param id 成员id
     * @return 返回成员
     */
    UserDTO getUserById(int id);

    /**
     * 判断是否登陆成功
     * @param loginParam 登陆表单
     * @return 成功与否
     */
    UserDTO login(LoginParam loginParam);

    /**
     * 注册功能
     * @param accNumber 账号
     * @param passWord 密码
     */
    void register(String accNumber, String passWord);

    /**
     * 关注
     * @param followParam 关注表单
     * @return 消息
     */
    String follow(FollowParam followParam);

    /**
     * 取关
     * @param followParam 关注表单
     * @return 消息
     */
    String unfollow(FollowParam followParam);

    /**
     * 获取关注
     * @param id 用户id
     * @return 关注用户列表
     */
    List<UserDTO> getAllFollows(int id);

    /**
     * 获取粉丝
     * @param id 用户id
     * @return 粉丝用户列表
     */
    List<UserDTO> getAllFollowers(int id);

    /**
     * 更新
     * @param user 用户
     * @return 值
     */
    int updateById(User user);

    // 持续打卡时间+1
    int addClockInContinuity(int id);

    // 持续打卡时间清零
    int clearClockInContinuity(int id);

    // 总共打卡时间+1
    int addClockInTotal(int id);

    // 总共学习时间+1
    int addStudyTime(int id);

    // 总共识图+1
    int addIdentifyImg(int id);
}
