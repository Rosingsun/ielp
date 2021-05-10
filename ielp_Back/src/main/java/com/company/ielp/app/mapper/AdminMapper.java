package com.company.ielp.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.ielp.app.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    Admin login(String accNumber, String passWord);

    Admin isAdminExist(String adminName);
}
