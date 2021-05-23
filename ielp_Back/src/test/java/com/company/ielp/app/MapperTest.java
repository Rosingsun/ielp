package com.company.ielp.app;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.DynamicInteractionMapper;
import com.company.ielp.app.mapper.UserInfoMapper;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.mapper.UserRelationMapper;
import com.company.ielp.app.model.entity.DynamicInteraction;
import com.company.ielp.app.model.entity.User;
import com.company.ielp.app.model.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * 常规Mapper插入删除测试
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserRelationMapper userRelationMapper;

    @Autowired
    DynamicInteractionMapper dynamicInteractionMapper;


    @Test
    void userMapperTest() {

        // 1、新建
        User user = new User();
        UserInfo userInfo = new UserInfo();
        user.setEmail("123@qq.com");
        user.setPhoneNumber("19858161666");
        user.setPassWord("996");
        userInfo.setBirthday(new Date());
        userInfo.setNickName("幕冬666");

        // 2、插入
        userMapper.insert(user);
        userInfo.setUserId(user.getId());

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        userInfoMapper.insert(userInfo);
        List<UserInfo> userInfos = userInfoMapper.selectList(null);
        userInfos.forEach(System.out::println);

        System.out.println("------------------------------------");

        // 3、删除
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        userInfoMapper.delete(queryWrapper);
        userMapper.deleteById(user.getId());

        users = userMapper.selectList(null);
        users.forEach(System.out::println);
        userInfos = userInfoMapper.selectList(null);
        userInfos.forEach(System.out::println);
    }

    @Test
    void dynamicTest() {
        List<DynamicInteraction> list = dynamicInteractionMapper.selectList(null);
        list.forEach(System.out::println);
    }
}