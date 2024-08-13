
package com.form.service.impl;

import java.sql.SQLException;
import com.form.dao.UserDao;
import com.form.service.UserService;
import com.form.viewBean.UserBean;

public class UserServiceImpl implements UserService {
	

	private UserDao userDao;

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserBean isValidUser(String email) throws SQLException {
		
		return userDao.userInfo(email);
	}

	@Override
	public boolean addUser(UserBean userBean) throws SQLException {
		return userDao.addUser(userBean);
	}

	@Override
	public boolean editUser(UserBean userBean) throws SQLException {
		return userDao.editUser(userBean);
	}

	@Override
	public UserBean userInfo(String email) throws SQLException {
		return userDao.userInfo(email);
	}



	
}