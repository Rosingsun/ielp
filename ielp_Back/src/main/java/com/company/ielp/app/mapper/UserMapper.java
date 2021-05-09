package com.company.ielp.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.ielp.app.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User login(String accNumber, String passWord);

    User beUsed(String accNumber);

    int lastId();



//    // 持续打卡时间+1
//    int addClockInContinuity(int id);
//
//    // 持续打卡时间清零
//    int clearClockInContinuity(int id);
//
//    // 总共打卡时间+1
//    int addClockInTotal(int id);
//
//    // 总共学习时间+1
//    int addStudyTime(int id);
//
//    // 总共识图+1
//    int addIdentifyImg(int id);

}
