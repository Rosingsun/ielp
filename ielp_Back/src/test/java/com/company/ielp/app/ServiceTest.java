package com.company.ielp.app;

import com.company.ielp.app.model.dto.UserInfoDTO;
import com.company.ielp.app.model.params.LoginParam;
import com.company.ielp.app.model.params.RegisterParam;
import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    void userServiceTest() {
        LoginParam loginParam = new LoginParam();
        RegisterParam registerParam = new RegisterParam();

        registerParam.setEmail("123@mu.com");
        registerParam.setPassWord("231");
        registerParam.setNickName("张三");
        registerParam.setSex("男");

        userService.register(registerParam);

        loginParam.setAccountNum("123@mu.com");
        loginParam.setPassWord("231");

        UserInfoDTO login = userService.login(loginParam);

        System.out.println(login);
    }

}
