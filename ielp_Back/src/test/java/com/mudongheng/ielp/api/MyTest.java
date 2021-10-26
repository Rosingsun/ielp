package com.mudongheng.ielp.api;

import com.mudongheng.ielp.api.model.param.LoginParam;
import com.mudongheng.ielp.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
@SpringBootTest
public class MyTest {

    @Autowired
    UserService userService;

    @Test
    void test1() {
        System.out.println(userService.getById(123));
        System.out.println(userService.getBaseMapper().selectById(123214214));

    }

}
