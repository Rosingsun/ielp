package com.company.ielp.app.controller;

import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.vo.BaseVO;
import com.company.ielp.app.model.vo.UserVO;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 为前端的用户操作提供接口
 *
 * @author 幕冬儿
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    // 关于这个缓存的问题找个时间解决了
    final static String PATH_NAME = "D:\\缓存\\ielp\\";

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转到登陆界面
     *
     * @return 登陆界面
     */
    @GetMapping(value = {"/", "/loginPage"})
    public String loginPage() {
        return "login_page";
    }

    /**
     * 登陆
     *
     * @param loginParam 登陆表单
     * @return 用户
     */
    @PostMapping("/login")
    @ResponseBody
    public UserVO login(LoginParam loginParam) {
        UserVO data = new UserVO();

        UserDTO userDTO = userService.login(loginParam);

        if (userDTO != null) {
            data.setUser(userDTO);
            data.setLogin(true);
            data.setMsg("登陆成功！");
            data.setState(BaseVO.SUCCESS);
        } else {
            data.setLogin(false);
            data.setMsg("登陆失败，请检查账号密码！");
            data.setState(BaseVO.INTERNAL_SERVER_ERROR);
        }

        return data;

    }

    /**
     * 上传图像
     * @param profile 头像
     * @return 上传成功
     * @throws IOException 传输异常
     */
    @PostMapping("/upload-profile")
    @ResponseBody
    public String upload(MultipartFile profile) throws IOException {
        log.info("上传文件：{}，{}", profile.getOriginalFilename(), profile.getSize());

        if (!profile.isEmpty()) {
            String originalFilename = profile.getOriginalFilename();
            profile.transferTo(new File(PATH_NAME + originalFilename));
        }

        return "上传成功！";
    }
}
