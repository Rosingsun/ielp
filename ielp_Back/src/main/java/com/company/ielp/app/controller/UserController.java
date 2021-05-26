package com.company.ielp.app.controller;

import com.company.ielp.app.annotation.PassToken;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.vo.BaseVO;
import com.company.ielp.app.model.vo.TokenVO;
import com.company.ielp.app.model.vo.UserVO;
import com.company.ielp.app.service.UserService;
import com.company.ielp.app.utils.JwtUtil;
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

    final String GET_SUCCESS = "用户获取成功！";
    final String NO_USER = "没有该用户！";
    final String OTHER_FAIL = "其他异常！";

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private Integer tokenAnalysis(String token) {
        Integer i = JwtUtil.getAudience(token);

        if (i == null) {
            log.info("token异常，请检查token或者重新登陆！");
            return null;
        }

        return i;
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
        try {
            tokenVO = new TokenVO(userService.login(loginParam), "登陆成功！", BaseVO.SUCCESS);
        } catch (Exception e) {
            tokenVO= new TokenVO("null", e.getMessage(), BaseVO.INTERNAL_SERVER_ERROR);
        }
        return tokenVO;
    }

    @GetMapping("/getUser")
    @ResponseBody
    public UserVO getUser(@RequestHeader String token) {
        UserVO data = new UserVO();

        Integer userId = tokenAnalysis(token);

        if (userId != null) {
            UserDTO userDTO = userService.getUserById(userId);

            if (userDTO == null) {
                data.setMsg(NO_USER);
                data.setState(BaseVO.INTERNAL_SERVER_ERROR);
                return null;
            }

            data.setUser(userDTO);
            data.setMsg(GET_SUCCESS);
            data.setState(BaseVO.SUCCESS);

            return data;
        }

        data.setMsg("token异常！");
        data.setState(BaseVO.INTERNAL_SERVER_ERROR);
        return null;

    }


    @GetMapping("/getTest")
    @ResponseBody
    @PassToken
    public String getTest(@RequestHeader String token) {
        return null;
    }

}
