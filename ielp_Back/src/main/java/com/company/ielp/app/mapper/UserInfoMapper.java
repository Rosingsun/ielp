package com.company.ielp.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.ielp.app.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo getUserInfo(int id);


}
