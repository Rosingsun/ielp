package com.company.ielp.app;

import com.company.ielp.app.model.User;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        List<User> allUser = userService.getAllUser();
        allUser.forEach(System.out::println);
    }
}
