package com.form.dao;

import java.sql.SQLException;

import com.form.viewBean.CartBean;
import com.form.viewBean.OrderBean;
import com.form.viewBean.UserBean;

public interface OrderDao {

	public UserBean ordercheckout(String email) throws SQLException;

	public CartBean totalpayment(String email) throws SQLException;
	public OrderBean charges() throws SQLException;

	public Boolean submitdatas(OrderBean orderBean) throws SQLException;


	public OrderBean getsummarydatas(String email) throws SQLException;


}
