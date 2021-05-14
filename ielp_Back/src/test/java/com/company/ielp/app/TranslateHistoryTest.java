package com.company.ielp.app;

import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TranslateHistoryTest {


    @Autowired
    UserService userService;


    @Test
    void insertTest() {
//        User user = userService.getUserById(1);
    }
}
