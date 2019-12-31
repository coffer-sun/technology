package com.fanpin.service;

import com.fanpin.entity.Admin;

import java.util.List;

public interface IAdminSvc {
    Admin selAdmByID(Integer adminid);

    int checkLogin(Admin admin);

    List<Admin> getAdminList();

    int deleteAdminById(Integer amninid);

    int updateAdminById(Admin admin);

    int addAdmin(Admin admin);
}
