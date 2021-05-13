package com.company.ielp.app.controller;

import com.company.ielp.app.model.Translate;
import com.company.ielp.app.model.User;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    final UserService userService;
    final TranslateService translateService;

    public UserController(UserService userService, TranslateService translateService) {
        this.userService = userService;
        this.translateService = translateService;
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

    @PostMapping("/translate")
    @ResponseBody
    public String translate(Translate t) {
        t.setTranslatedTime(new Date());
        translateService.translateWord(t);

        String s = String.format("翻译记录传入：{%s}", t);
        log.info(s);
        return s;
    }

}
