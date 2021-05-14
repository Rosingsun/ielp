package com.company.ielp.app.service;

import com.company.ielp.app.model.User;

import java.util.List;

/**
 * 为用户提供相关服务
 * @author 幕冬儿
 * @see com.company.ielp.app.service.impl.UserServiceImpl
 */
public interface UserService {

    /**
     * 获取所有成员
     * @return 成员列表
     */
    List<User> getAllUser();

    /**
     * 根据id获取成员
     * @param id 成员id
     * @return 返回成员
     */
    User getUserById(int id);

    /**
     * 判断是否登陆成功
     * @param user 用户
     * @return 成功与否
     */
    User login(User user);

    /**
     * 判断这个用户是否存在
     * @param accNumber 用户名
     * @return 成功与否
     */
    Boolean beUsed(String accNumber);

    /**
     * 注册功能
     * @param accNumber 账号
     * @param passWord 密码
     */
    void register(String accNumber, String passWord);

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
