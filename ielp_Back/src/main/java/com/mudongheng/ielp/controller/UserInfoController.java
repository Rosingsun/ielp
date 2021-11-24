package com.mudongheng.ielp.controller;

import com.mudongheng.ielp.exception.UserException;
import com.mudongheng.ielp.model.entity.User;
import com.mudongheng.ielp.service.UserService;
import com.mudongheng.ielp.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 幕冬
 * @since 2021年10月27日
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    private final UserService userService;

    public UserInfoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get-user-info-by-id")
    public User getUserInfoById(@RequestBody Integer id) throws Exception {
        User user = userService.getById(id);
        if (user == null) {
            throw new UserException("用户不存在");
        }
        return UserUtil.removeUserPassword(userService.getById(id));
    }

}
