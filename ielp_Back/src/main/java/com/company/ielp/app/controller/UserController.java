package com.company.ielp.app.controller;

import com.company.ielp.app.annotation.PassToken;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.dto.UserInfoDTO;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.vo.BaseVO;
import com.company.ielp.app.model.vo.TokenVO;
import com.company.ielp.app.model.vo.UserVO;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 为前端的用户操作提供接口
 *
 * @author 幕冬儿
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    final String LOGIN_FAIL = "登陆失败，账号密码错误！";
    final String GET_SUCCESS = "用户获取成功！";
    final String NO_USER = "没有该用户！";

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转到登陆界面
     *
     * @return 登陆界面
     */
    @PassToken
    @GetMapping(value = {"/loginPage"})
    public String loginPage() {
        return "login_page";
    }

    /**
     * 登陆
     *
     * @param loginParam 登陆表单
     * @return 用户
     */
    @PassToken
    @PostMapping("/login")
    @ResponseBody
    public TokenVO login(LoginParam loginParam) {
        TokenVO tokenVO;
        String token = userService.login(loginParam);
        if (token != null) {
            tokenVO = new TokenVO(token, "登陆成功！", BaseVO.SUCCESS);
        } else {
            tokenVO= new TokenVO(null, LOGIN_FAIL, BaseVO.INTERNAL_SERVER_ERROR);
        }
        return tokenVO;
    }

    @GetMapping("/get-user")
    @ResponseBody
    public UserVO getUser(@RequestHeader String token) {
        UserVO data;
        UserDTO userDTO = userService.getUser(token);
        if (userDTO != null) {
            data = new UserVO(userDTO, GET_SUCCESS, BaseVO.SUCCESS);
        } else {
            data = new UserVO(NO_USER, BaseVO.INTERNAL_SERVER_ERROR);
        }
        return data;
    }

    @GetMapping("/get-user-info")
    @ResponseBody
    public UserVO getUserInfo(@RequestHeader String token) {
        UserVO data;
        UserInfoDTO userInfoDTO = userService.getUserInfo(token);
        if (userInfoDTO != null) {
            data = new UserVO(userInfoDTO, GET_SUCCESS, BaseVO.SUCCESS);
        } else {
            data = new UserVO(NO_USER, BaseVO.INTERNAL_SERVER_ERROR);
        }
        return data;
    }


    @GetMapping("/getTest")
    @ResponseBody
    @PassToken
    public String getTest(@RequestHeader String token) {
        return null;
    }

}
