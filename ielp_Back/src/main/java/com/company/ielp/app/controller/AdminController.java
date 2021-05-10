package com.company.ielp.app.controller;

import com.company.ielp.app.model.Admin;
import com.company.ielp.app.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class AdminController {
    final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/testPage")
    public String testPage() {
        return "test";
    }

    @PostMapping("/admin/login")
    @ResponseBody
    public String login(Admin admin) {
        Admin login = adminService.login(admin);

        boolean isLogin = (login != null);

        String s = String.format("用户：{%s}登陆状态：" + isLogin, login);

        log.info(s);
        return s;
    }

    @PostMapping("/admin/register")
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
}
