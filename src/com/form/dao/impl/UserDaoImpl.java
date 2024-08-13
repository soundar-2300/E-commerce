package com.form.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.sql.DataSource;

import com.form.dao.UserDao;
import com.form.viewBean.UserBean;

/**
 * @author CENTAUR
 */

public class UserDaoImpl implements UserDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean isValidUser(UserBean userBean) throws SQLException {
		byte[] passkey = userBean.getPassword().getBytes();
		String decod = Base64.getEncoder().encodeToString(passkey);

		String query = "Select * from tablebase where email=? and password=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userBean.getEmail());
		pstmt.setString(2, decod);
		ResultSet rS = pstmt.executeQuery();
		if (rS.next()) {
			return true;
		}
		return false;
	}

	public boolean addUser(UserBean userBean) throws SQLException {
		byte[] image = null;
		try {
		image = userBean.getImage().getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] password = null;
		password = userBean.getPassword().getBytes();
		String encryp = Base64.getEncoder().encodeToString(password);

		String query = "INSERT INTO tablebase(`firstName`,`lastName`,`email`,`password`,`mobile`,`image`,`flatno`,`area`,`pincode`,`landmark`,`towncity`,`state`,`country`,`addaddress`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userBean.getFirstName());
		pstmt.setString(2, userBean.getLastName());
		pstmt.setString(3, userBean.getEmail());
		pstmt.setString(4, encryp);
		pstmt.setString(5, userBean.getMobile());
	    pstmt.setBytes(6, image);
		pstmt.setString(7, userBean.getFlatno());
		pstmt.setString(8, userBean.getArea());
		pstmt.setInt(9, userBean.getPincode());
		pstmt.setString(10, userBean.getLandmark());
		pstmt.setString(11, userBean.getTowncity());
		pstmt.setString(12, userBean.getState());
		pstmt.setString(13, userBean.getCountry());
		pstmt.setString(14, userBean.getAddaddress());

		// pstmt.setString(11,userBean.getPaymentmethod());

		int rS = pstmt.executeUpdate();
		if (rS > 0) {
			return true;
		}

		return false;
	}

	public UserBean userInfo(String email) throws SQLException {
		String query = "Select * from tablebase where email = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet resultSet = pstmt.executeQuery();
		UserBean userBean = new UserBean();
		if (resultSet.next()) {
			userBean.setFirstName(resultSet.getString("firstName"));
			userBean.setLastName(resultSet.getString("lastName"));
			userBean.setEmail(resultSet.getString("email"));
			userBean.setMobile(resultSet.getString("mobile"));
			userBean.setFlatno(resultSet.getString("flatno"));
			userBean.setArea(resultSet.getString("area"));
			userBean.setPincode(resultSet.getInt("pincode"));
			userBean.setLandmark(resultSet.getString("landmark"));
			userBean.setTowncity(resultSet.getString("towncity"));
			userBean.setState(resultSet.getString("state"));
			userBean.setCountry(resultSet.getString("country"));
			userBean.setAddaddress(resultSet.getString("addaddress"));
			byte[] img = resultSet.getBytes("image");
			String photo = Base64.getEncoder().encodeToString(img);
			userBean.setPic(photo);
		}

		return userBean;
	}

	@Override
	public boolean editUser(UserBean userBean) throws SQLException {
		/*
		 * byte[] doodle = null; try { doodle = userBean.getImage().getBytes(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 * 
		 * byte[] pass = userBean.getPassword().getBytes(); String encrypted =
		 * Base64.getEncoder().encodeToString(pass);
		 */
		String query = "UPDATE  tablebase set firstName=?,lastName=?,email=?,mobile=?,flatno=?,area=?,pincode=?,towncity=?,state=?,country=?,addaddress=? where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userBean.getFirstName());
		pstmt.setString(2, userBean.getLastName());
		pstmt.setString(3, userBean.getEmail());
		
		pstmt.setString(4, userBean.getMobile());
		pstmt.setString(5, userBean.getFlatno());
		pstmt.setString(6, userBean.getArea());
		pstmt.setInt(7, userBean.getPincode());
		pstmt.setString(8, userBean.getTowncity());
		pstmt.setString(9, userBean.getState());
		pstmt.setString(10, userBean.getCountry());
		pstmt.setString(11, userBean.getAddaddress());
		pstmt.setString(12, userBean.getEmail());
		int detailUpdate = pstmt.executeUpdate();
		if ( detailUpdate > 0) {
			return true;
		}
		return false;
	}

	public static boolean existsEmail(String email) {

		return false;
	}

	
}