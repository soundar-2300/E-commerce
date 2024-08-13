package com.form.dao;

import java.sql.SQLException;

import com.form.viewBean.UserBean;

public interface UserDao {
	
    public boolean isValidUser(UserBean userBean) throws SQLException;

	public boolean addUser(UserBean userBean) throws SQLException;

	public UserBean userInfo(String email) throws SQLException;

	public boolean editUser(UserBean userBean) throws SQLException;

	
}