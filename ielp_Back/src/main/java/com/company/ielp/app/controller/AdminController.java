package com.company.ielp.app.controller;

import com.company.ielp.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/admin/login")
    boolean login(
            @RequestParam(name = "accNumber") String accNumber,
            @RequestParam(name = "passWord") String passWord) {
        return adminService.login(accNumber, passWord);
    }
}
