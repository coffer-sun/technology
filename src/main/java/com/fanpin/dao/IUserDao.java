package com.fanpin.dao;

import java.util.List;

import com.fanpin.entity.Log;
import com.fanpin.entity.User;

//顶部单行注释上留空行
public interface IUserDao {        //尾部单行注释前要留白

    int checkUid(Integer uid);    //检测账号是否存在

    int checkLogin(User user);    //检测账号与密码是否匹配

    User showUserInfo(Integer uid);    //显示用户个人信息

    int upUser(User user);    //修改用户信息

    int insertUserLog(Log log);    //插入用户操作日志

    List<User> selAllUser();    //查询所有用户

    int addUser(User user);    //注册

    User selUserByUname(String uname); //用户名查找

    int delUserById(Integer uid);   //admin删除用户
}
