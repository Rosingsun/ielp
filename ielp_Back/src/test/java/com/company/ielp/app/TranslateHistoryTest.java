package com.company.ielp.app;

import com.company.ielp.app.model.translate.TranslateHistory;
import com.company.ielp.app.service.TranslateHistoryService;
import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TranslateHistoryTest {

    @Autowired
    TranslateHistoryService translateHistoryService;

    @Autowired
    UserService userService;

    @Test
    void test1() {
        List<TranslateHistory> history = translateHistoryService.getTranslateHistoryByUid(1);
        history.forEach(System.out::println);
    }

    @Test
    void insertTest() {
//        User user = userService.getUserById(1);
    }
}
