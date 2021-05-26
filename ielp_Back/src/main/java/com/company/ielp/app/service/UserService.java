package com.company.ielp.app.service;

import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.dto.UserInfoDTO;
import com.company.ielp.app.model.params.FollowParam;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.params.RegisterParam;

import java.util.List;

/**
 * 为用户提供相关服务
 * @author 幕冬儿
 * @see com.company.ielp.app.service.impl.UserServiceImpl
 */
public interface UserService {
    /**
     * 判断是否登陆成功
     * @param loginParam 登陆表单
     * @return Token信息
     */
    String login(LoginParam loginParam);

    /**
     * 注册功能
     * @param registerParam 注册表单
     */
    void register(RegisterParam registerParam);

    /**
     * 通过id获取用户安全信息
     * @param token token信息
     * @return 用户安全信息
     */
    UserDTO getUser(String token);

    /**
     * 通过id获取用户详情信息
     * @param token token信息
     * @return 用户详情信息
     */
    UserInfoDTO getUserInfo(String token);

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
    List<UserInfoDTO> getAllFollows(int id);

    /**
     * 获取粉丝
     * @param id 用户id
     * @return 粉丝用户列表
     */
    List<UserInfoDTO> getAllFollowers(int id);

}
