package com.mudongheng.ielp.api;

import com.mudongheng.ielp.api.mapper.UserMapper;
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

    @Autowired
    UserMapper userMapper;

    @Test
    void test1() {

        try {
            System.out.println(userMapper.deleteById(2));
            System.out.println(userMapper.deleteById(12314211));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
