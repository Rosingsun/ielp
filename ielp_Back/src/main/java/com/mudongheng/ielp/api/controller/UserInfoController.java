package com.mudongheng.ielp.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 幕冬
 * @since 2021年10月27日
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @PostMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("hi");
    }

}
