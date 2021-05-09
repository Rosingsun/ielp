package com.company.ielp.app.controller;

import com.company.ielp.app.model.User;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取所有用户
     * @return 用户列表
     */
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户
     */
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam(name = "id") int id) {
        return userService.getUserById(id);
    }

    /**
     * 跳转到登陆界面
     * @return 登陆界面
     */
    @GetMapping(value = {"/", "/loginPage"})
    public String loginPage() {
        return "login";
    }

    /**
     * 尝试登陆
     * @param user 根据前端自动获取user
     * @param session 会话
     * @param model 样式
     * @return 用户
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session, Model model) {
        log.info(user.toString());

        // 检查user中的账号密码是否存在于数据库
        // 然后……
        // 嗯

        return user.toString();
    }
}
