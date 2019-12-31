package com.fanpin.dao;

import com.fanpin.entity.Admin;

import java.util.List;

public interface IAdminDao {
    Admin selAdmByID(Integer adminid);

    int checkLogin(Admin admin);

    List<Admin> getAdminList(); //获取所有管理员列表

    int deleteAdminById(Integer amninid);

    int updateAdminById(Admin admin);

    int addAdmin(Admin admin);
}
