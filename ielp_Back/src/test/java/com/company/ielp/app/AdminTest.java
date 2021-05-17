package com.company.ielp.app;

import com.company.ielp.app.model.params.FollowParam;
import com.company.ielp.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {

    @Autowired
    UserService userService;

    /**
     * 插入测试
     */
    @Test
    public void insertTest() {
        FollowParam followParam = new FollowParam();
        followParam.setUid(2);
        followParam.setFollowId(4);
        userService.follow(followParam);
    }

    @Test
    public void insertTest2() {
        userService.register("12366@qq.com", "123456");
    }
}
