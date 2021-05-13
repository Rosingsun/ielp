package com.company.ielp.app.service;

import com.company.ielp.app.model.Admin;

/**
 * 为管理员提供相关服务
 * @author 幕冬儿
 * @see com.company.ielp.app.service.impl.AdminServiceImpl
 */
public interface AdminService {

    /**
     * 管理员登陆
     * @param admin 管理员
     * @return 管理员
     */
    Admin login(Admin admin);

    /**
     * 管理员注册
     * @param admin 管理员
     * @return 管理员
     */
    Admin register(Admin admin);
}
