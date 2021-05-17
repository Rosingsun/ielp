package com.company.ielp.app.controller;

import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.entity.Admin;
import com.company.ielp.app.model.vo.TranslateVO;
import com.company.ielp.app.model.vo.UserVO;
import com.company.ielp.app.service.AdminService;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户
     */
    @GetMapping("/getUserById")
    @ResponseBody
    public UserVO getUserById(@RequestParam(name = "id") int id) {
        UserVO data = new UserVO();

        UserDTO user = userService.getUserById(id);

        // 直接获取的用户是没有登陆的
        data.setTime(new Date());
        data.setLogin(false);

        if (user != null) {
            data.setUser(user);
            data.setMsg("获取用户成功！");
            data.setState(200);
        } else {
            data.setMsg("获取用户失败！");
            data.setState(500);
        }
        return data;
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(Admin admin) {
        Admin login = adminService.login(admin);

        boolean isLogin = (login != null);

        String s = String.format("管理员：{%s}登陆状态：" + isLogin, login);

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
    public TranslateVO getUserTranslateHistory(int userId) {
        List<TranslateDTO> histories = translateService.getTranslateHistoryByUid(userId);

        TranslateVO vo = new TranslateVO();
        vo.setTime(new Date());
        vo.setMsg("翻译记录");
        vo.setState(500);
        vo.setData(histories);

        return vo;
    }

    @GetMapping("/getUserTranslateCollection")
    @ResponseBody
    public TranslateVO getUserTranslateCollection(int userId) {
        List<TranslateDTO> collections = translateService.getCollectionsByUid(userId);

        TranslateVO vo = new TranslateVO();
        vo.setTime(new Date());
        vo.setMsg("收藏记录");
        vo.setState(200);
        vo.setData(collections);

        return vo;
    }
}
