package com.company.ielp.app.controller;

import com.company.ielp.app.model.Admin;
import com.company.ielp.app.model.User;
import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.model.translate.TranslateHistory;
import com.company.ielp.app.service.AdminService;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    final AdminService adminService;
    final UserService userService;
    final TranslateService translateService;

    public AdminController(AdminService adminService, UserService userService, TranslateService translateService) {
        this.adminService = adminService;
        this.userService = userService;
        this.translateService = translateService;
    }

    @GetMapping("/testPage")
    public String testPage() {
        return "test";
    }

    /**
     * 获取所有用户
     * @return 用户列表
     */
    @GetMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam(name = "id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(Admin admin) {
        Admin login = adminService.login(admin);

        boolean isLogin = (login != null);

        String s = String.format("用户：{%s}登陆状态：" + isLogin, login);

        log.info(s);
        return s;
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(Admin admin) {
        log.info("注册信息：{}", admin.toString());

        Admin registerAdmin = adminService.register(admin);

        String s;

        if (registerAdmin == null) {
            s = "注册失败，用户已存在！";
            log.info(s);
            return s;
        }

        s = String.format("注册用户：{%s}", registerAdmin);
        log.info(s);
        return s;
    }

    @GetMapping("/getUserTranslateHistory")
    @ResponseBody
    public String getUserTranslateHistory(int userId) {
        List<TranslateHistory> history = translateService.getTranslateHistoryByUid(userId);
        StringBuilder s = new StringBuilder();
        for (TranslateHistory h : history) {
            s.append(h).append("<br/>");
        }
        return s.toString();
    }

    @GetMapping("/getUserTranslateCollection")
    @ResponseBody
    public String getUserTranslateCollection(int userId) {
        List<TranslateCollection> collections = translateService.getCollectionsByUid(userId);
        StringBuilder s = new StringBuilder();
        for (TranslateCollection h : collections) {
            s.append(h).append("<br/>");
        }
        return s.toString();
    }
}
