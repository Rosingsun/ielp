package com.company.ielp.app;

import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.model.User;
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
        User user = new User();

        user.setEmail("66@qq.com");
        user.setPassWord("666");

        System.out.println(userService.login(user));

        User user2 = new User();

        user2.setEmail("62@qq.com");
        user2.setPhoneNumber("19858161283");
        user2.setPassWord("666");

        System.out.println(userService.login(user2));

        User user3 = new User();

        user3.setEmail("61@qq.com");
        user3.setPhoneNumber("19858161282");
        user3.setPassWord("666");

        System.out.println(userService.login(user3));
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
