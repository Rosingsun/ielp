package com.company.ielp.app.controller;

import com.company.ielp.app.annotation.PassToken;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.dto.UserInfoDTO;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.params.TokenParam;
import com.company.ielp.app.model.vo.BaseVO;
import com.company.ielp.app.model.vo.UserVO;
import com.company.ielp.app.service.UserService;
import com.company.ielp.app.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 为前端的用户操作提供接口
 *
 * @author 幕冬儿
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
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
    public UserVO login(LoginParam loginParam) {
        UserVO data = new UserVO();

        UserInfoDTO login = userService.login(loginParam);

        if (login != null) {
            // 创建token
            String token = JwtUtil.createToken(login.getUserId());
            // 传递给前端
            data.setUserInfo(login);
            data.setLogin(true);
            data.setToken(token);
            data.setMsg("登陆成功！");
            data.setState(BaseVO.SUCCESS);

        } else {
            data.setLogin(false);
            data.setMsg("登陆失败，请检查账号密码！");
            data.setState(BaseVO.INTERNAL_SERVER_ERROR);
        }

        return data;
    }

    @GetMapping("/getSelf")
    @ResponseBody
    public UserVO getSelf(TokenParam tokenParam) {
        UserVO data = new UserVO();

        String token = tokenParam.getToken();

        // 对于这一步，是可能因为会产生空指针的问题
        // 但都到了这一步，理应是不会出现空token的事情
        // 准备之后再优化

        Integer s = JwtUtil.getAudience(token);

        if (s == null) {
            log.info("token异常，请检查token或者重新登陆！");
            data.setMsg("token异常，请检查token或者重新登陆！");
            data.setState(BaseVO.INTERNAL_SERVER_ERROR);
            return null;
        }

        UserDTO userDTO = userService.getUserById(s);

        if (userDTO == null) {
            data.setMsg("没有该用户，请注册！");
            data.setState(BaseVO.INTERNAL_SERVER_ERROR);
        }

        data.setUser(userDTO);
        data.setMsg("获取成功！");
        data.setState(BaseVO.SUCCESS);

        return data;
    }

}
