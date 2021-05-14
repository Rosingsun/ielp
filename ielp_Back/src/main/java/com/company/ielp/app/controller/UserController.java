package com.company.ielp.app.controller;

import com.company.ielp.app.model.User;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 为前端的用户操作提供接口
 *
 * @author 幕冬儿
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    // 关于这个缓存的问题找个时间解决了
    final static String PATH_NAME = "D:\\缓存\\ielp\\";

    final UserService userService;
    final TranslateService translateService;

    public UserController(UserService userService, TranslateService translateService) {
        this.userService = userService;
        this.translateService = translateService;
    }

    /**
     * 跳转到登陆界面
     *
     * @return 登陆界面
     */
    @GetMapping(value = {"/", "/loginPage"})
    public String loginPage() {
        return "login";
    }

    /**
     * 尝试登陆
     *
     * @param user 根据前端自动获取user
     * @return 用户
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(User user) {
        log.info(user.toString());

        // 检查user中的账号密码是否存在于数据库
        // 然后……
        // 嗯

        return user.toString();
    }

    /**
     * 上传图像
     * @param profile 头像
     * @return 上传成功
     * @throws IOException 传输异常
     */
    @PostMapping("/upload-profile")
    public String upload(MultipartFile profile) throws IOException {
        log.info("上传文件：{}，{}", profile.getOriginalFilename(), profile.getSize());

        if (!profile.isEmpty()) {
            String originalFilename = profile.getOriginalFilename();
            profile.transferTo(new File(PATH_NAME + originalFilename));
        }

        return "上传成功！";
    }
}
