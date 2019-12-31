package com.fanpin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanpin.dao.IUserDao;
import com.fanpin.entity.Log;
import com.fanpin.entity.User;
import com.fanpin.service.ILoginSvc;

@Service
public class LoginSvcIMPL implements ILoginSvc {

	@Resource
	private IUserDao userDao;

	@Override
	public int checkUid(Integer uid) {
		return userDao.checkUid(uid);
	}
	
	@Override
	public int checkLogin(User user) {
		return userDao.checkLogin(user);
	}

	@Override
	public User showUserInfo(Integer uid) {
		return userDao.showUserInfo(uid);
	}

	@Override
	public int upUser(User user) {
		return userDao.upUser(user);
	}

	@Override
	public int insertUserLog(Log log) {
		return userDao.insertUserLog(log);
	}

	@Override
	public List<User> selAllUser() {
		return userDao.selAllUser();
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public User selUserByUname(String uname) {
		return userDao.selUserByUname(uname);
	}

	@Override
	public int delUserById(Integer uid) {
		return userDao.delUserById(uid);
	}

}
