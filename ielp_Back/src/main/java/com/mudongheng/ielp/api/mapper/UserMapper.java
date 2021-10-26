package com.mudongheng.ielp.api.mapper;

import com.mudongheng.ielp.api.exception.UserException;
import com.mudongheng.ielp.api.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    default User getUserNotNull(Integer userId) throws UserException {
        User user = this.selectById(userId);
        if (user == null) {
            throw new UserException("用户不存在");
        }
        return user;
    }

}




