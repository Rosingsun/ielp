package com.ielp.service;


import java.util.List;
import com.ielp.pojo.User;
public interface UserService{

    List<User> selectUserList();

    List<User> userList();
}
