package com.fanpin.service;

import java.util.List;

import com.fanpin.entity.Log;
import com.fanpin.entity.User;

public interface ILoginSvc {

    int checkUid(Integer uid);

    int checkLogin(User user);

    User showUserInfo(Integer uid);

    int upUser(User user);

    int insertUserLog(Log log);

    List<User> selAllUser();

    int addUser(User user);

    User selUserByUname(String uname);

    int delUserById(Integer uid);
}
