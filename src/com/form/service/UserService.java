package com.form.service;

import java.sql.SQLException;

import com.form.viewBean.UserBean;

public interface UserService {

	public UserBean isValidUser(String email) throws SQLException;

	public boolean addUser(UserBean userBean) throws SQLException;

	public UserBean userInfo(String email) throws SQLException;

	public boolean editUser(UserBean userBean) throws SQLException;

	
}