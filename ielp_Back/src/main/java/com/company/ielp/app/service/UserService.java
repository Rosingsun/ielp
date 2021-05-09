package com.company.ielp.app.service;

import com.company.ielp.app.model.User;

import java.util.List;

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
     * @param accNumber 账号
     * @param passWord 密码
     * @return 成功与否
     */
    Boolean login(String accNumber, String passWord);

    Boolean beUsed(String accNumber);

    void register(String accNumber, String passWord);

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
