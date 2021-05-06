package com.ielp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ielp.service.UserService;
import com.ielp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/userList")
    public IPage UserList(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize) {
        List<User> list = userService.userList();
        Page<User> page = new Page<>(pageNum,pageSize);
        page.setRecords(list);
        return page;
    }


    @RequestMapping("/selectUserList")
    public List<User> selectUserList() {
        return userService.selectUserList();
    }
}