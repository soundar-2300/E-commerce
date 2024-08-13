package com.form.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.form.dao.CartDao;
import com.form.dao.OrderDao;
import com.form.viewBean.CartBean;
import com.form.viewBean.OrderBean;
import com.form.viewBean.UserBean;

public class OrderDaoImpl implements OrderDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
		@Override
	public UserBean ordercheckout(String email) throws SQLException {
		String query = "Select * from  tablebase where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet show = pstmt.executeQuery();
		UserBean userBean = new UserBean();
		if (show.next()) {
			userBean.setFirstName(show.getString("firstName"));
			userBean.setLastName(show.getString("lastName"));
			userBean.setEmail(show.getString("email"));
			userBean.setMobile(show.getString("mobile"));
			userBean.setFlatno(show.getString("flatno"));
			userBean.setArea(show.getString("area"));
			userBean.setPincode(show.getInt("pincode"));
			userBean.setLandmark(show.getString("landmark"));
			userBean.setTowncity(show.getString("towncity"));
			userBean.setState(show.getString("state"));
			userBean.setCountry(show.getString("country"));
			userBean.setAddaddress(show.getString("addaddress"));
			}
		return userBean;
	}

	
	@Override
	public OrderBean charges() throws SQLException {
		String query = "select * from cart where cartId=2704";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet extra = pstmt.executeQuery();
		OrderBean cartBean = new OrderBean();
		if (extra.next()) {
			cartBean.setCharges(extra.getInt("charges"));
		}
		return cartBean;
	}

	@Override
	public Boolean submitdatas(OrderBean orderBean) throws SQLException {
		String query = "Insert INTO ordersummary (`id`,`email`,`payout`,`datetime`,`paymentmethod`)VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, orderBean.getId());
		pstmt.setString(2, orderBean.getEmail());
		pstmt.setDouble(3,orderBean.getPayout());
		pstmt.setTimestamp(4, orderBean.getDatetime());
		pstmt.setString(5, orderBean.getPaymentmethod());
		int submit = pstmt.executeUpdate();
		if (submit > 0) {
			return true;
		}
		return false;
	}

	@Override
	public OrderBean getsummarydatas(String email) throws SQLException {
		String query="select * from ordersummary where email=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet result=pstmt.executeQuery();
		OrderBean  orderBean= new OrderBean();
		if(result.next()) {
			orderBean.setEmail(result.getString("email"));
		orderBean.setPayout(result.getDouble("payout"));
		orderBean.setPaymentmethod(result.getString("paymentmethod"));
		}
		return orderBean;
	}

	@Override
	public CartBean totalpayment(String email) throws SQLException {
		String query="select * from cart where email=?";
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet result=pstmt.executeQuery();
		CartBean cartBean=new CartBean();
		if(result.next()) {
			cartBean.setCartId(result.getInt("cartId"));
			cartBean.setEmail(result.getString("email"));
			cartBean.setTotalQuantity(result.getInt("totalQuantity"));
			cartBean.setTotalAmount(result.getDouble("totalAmount"));
			cartBean.setPayout(cartBean.getTotalAmount() + 70);
		
		}
		
		return cartBean;
	}


}