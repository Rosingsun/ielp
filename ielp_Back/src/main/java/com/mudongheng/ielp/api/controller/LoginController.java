package com.mudongheng.ielp.api.controller;

import com.mudongheng.ielp.api.exception.UserException;
import com.mudongheng.ielp.api.model.param.LoginParam;
import com.mudongheng.ielp.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginParam loginParam, HttpServletResponse response) {
        try {
            return userService.login(loginParam);
        } catch (UserException e) {
            log.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return e.getMessage();
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody LoginParam loginParam, HttpServletResponse response) {
        try {
            return userService.register(loginParam);
        } catch (UserException e) {
            log.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return e.getMessage();
        }
    }

}
