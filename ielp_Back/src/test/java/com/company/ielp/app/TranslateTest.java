package com.company.ielp.app;

import com.company.ielp.app.model.Translate;
import com.company.ielp.app.model.User;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TranslateTest {

    @Autowired
    TranslateService translateService;

    @Autowired
    UserService userService;

    @Test
    void test1() {
        List<Translate> history = translateService.getTranslateHistoryByUid(1);
        history.forEach(System.out::println);
    }

    @Test
    void insertTest() {
//        User user = userService.getUserById(1);
    }
}
