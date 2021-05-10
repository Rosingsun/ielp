package com.company.ielp.app;

import com.company.ielp.app.model.Admin;
import com.company.ielp.app.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {

    @Autowired
    AdminService adminService;

    /**
     * 插入测试
     */
    @Test
    public void insertTest() {
        Admin admin = new Admin();
        admin.setAdminName("zzddadmin");
        admin.setPassWord("123456");
        adminService.register(admin);
    }
}
