package com.company.ielp.app.service.impl;

import com.company.ielp.app.mapper.AdminMapper;
import com.company.ielp.app.model.entity.Admin;
import com.company.ielp.app.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin login(Admin admin) {
//        return adminMapper.login(admin.getAdminName(), admin.getPassWord());
        return null;
    }

    @Override
    public Admin register(Admin admin) {
//        Admin exist = adminMapper.isAdminExist(admin.getAdminName());
//        if (exist != null) {
//            return null;
//        }
//
//        adminMapper.insert(admin);
//
//        // 这一段需要优化，有点毛离谱……
//        // 但又没有太好的优化想法
//        List<Admin> admins = adminMapper.selectList(null);
//        return admins.get(admins.size() - 1);
        return null;
    }
}
