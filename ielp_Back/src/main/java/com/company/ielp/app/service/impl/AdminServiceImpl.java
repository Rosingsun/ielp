package com.company.ielp.app.service.impl;

import com.company.ielp.app.model.Admin;
import com.company.ielp.app.mapper.AdminMapper;
import com.company.ielp.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Boolean login(String accNumber, String passWord) {
        Admin admin = adminMapper.login(accNumber, passWord);
        return admin != null;
    }
}
