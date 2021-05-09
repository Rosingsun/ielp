package com.company.ielp.app;

import com.company.ielp.app.model.User;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    /**
     * 测试登陆功能是否正常
     */
    @Test
    void userLoginTest() {
        Boolean login1 = userService.login("1@zjsru.edu", "Admin666!?");
        System.out.println(login1);
        Boolean login2 = userService.login("1@2.edu", "667789!?");
        System.out.println(login2);
    }
    /**
     * 检验注册功能
     */
    @Test
    void accNumberBeUsedTest() {

        Boolean beUsed1 = userService.beUsed("1@zjsru.edu");
        System.out.println(beUsed1);

        Boolean beUsed2 = userService.beUsed("19858161283");
        System.out.println(beUsed2);

        Boolean beUsed3 = userService.beUsed("1@23122.edu");
        System.out.println(beUsed3);

        Boolean beUsed4 = userService.beUsed("112823");
        System.out.println(beUsed4);

        userService.register("admin@mudong.com", "66666");
    }

    @Test
    void updateTest() {
        User user = userService.getUserById(2);
        for (int i = 0; i < 100; i++) {
            user.setIdentifyImg(user.getIdentifyImg() + 1);
        }
        int i = userService.updateById(user);
        System.out.println(i);

        userService.addClockInContinuity(1);
        userService.clearClockInContinuity(1);
        userService.addClockInTotal(1);
        userService.addStudyTime(1);
        userService.addIdentifyImg(1);
    }
}
