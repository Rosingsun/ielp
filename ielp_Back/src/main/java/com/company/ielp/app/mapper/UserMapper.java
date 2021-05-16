package com.company.ielp.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.ielp.app.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
