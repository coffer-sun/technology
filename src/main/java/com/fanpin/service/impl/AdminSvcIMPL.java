package com.fanpin.service.impl;

import com.fanpin.dao.IAdminDao;
import com.fanpin.entity.Admin;
import com.fanpin.service.IAdminSvc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminSvcIMPL implements IAdminSvc {

    @Resource
    private IAdminDao adminDao;

    @Override
    public Admin selAdmByID(Integer adminid) {
        return adminDao.selAdmByID(adminid);
    }

    @Override
    public int checkLogin(Admin admin) {
        return adminDao.checkLogin(admin);
    }

    @Override
    public List<Admin> getAdminList() {
        return adminDao.getAdminList();
    }

    @Override
    public int deleteAdminById(Integer amninid) {
        return adminDao.deleteAdminById(amninid);
    }

    @Override
    public int updateAdminById(Admin admin) {
        return adminDao.updateAdminById(admin);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }
}
