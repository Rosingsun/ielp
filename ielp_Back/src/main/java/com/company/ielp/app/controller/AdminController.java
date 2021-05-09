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
        log.info(admin.toString());
        return admin.toString();
    }

    @PostMapping("/admin/register")
    @ResponseBody
    public String register(Admin admin) {
        log.info(admin.toString());
        return admin.toString();
    }
}
