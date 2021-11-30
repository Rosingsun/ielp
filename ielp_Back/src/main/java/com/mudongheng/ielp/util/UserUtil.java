package com.mudongheng.ielp.util;

import com.mudongheng.ielp.exception.UserException;
import com.mudongheng.ielp.model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 幕冬
 * @since 2021年11月24日
 */
public class UserUtil {

    /**
     * 通过请求获取用户id，用户id于Token处理中放入
     * @param request 请求
     * @return 用户id
     * @throws UserException 异常
     */
    public static Integer getUserIdFromRequest(HttpServletRequest request) throws UserException {
        Integer userId = (Integer) request.getAttribute("userId");
        if (userId == null) {
            throw new UserException("请求中不包含用户信息，拒绝访问");
        }
        return userId;
    }

    /**
     * 删除用户密码，返回给视图层
     * @param user 用户
     * @return 用户信息（去除密码）
     */
    public static User removeUserPassword(User user) {
        user.setPassword(null);
        return user;
    }

}
