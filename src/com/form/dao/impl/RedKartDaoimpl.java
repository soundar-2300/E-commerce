package com.form.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import com.form.dao.RedkartDao;
import com.form.viewBean.KartBean;

public class RedKartDaoimpl implements RedkartDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<KartBean> getcategory(KartBean kartBean) throws SQLException {
		String query = "select * from categorytyp where parentcategoryid=0";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		ResultSet category= pstmt.executeQuery();
		List<KartBean> kartBean1 = new ArrayList<>();
		while (category.next()) {
			KartBean redkart = new KartBean();
			redkart.setCategoryid(category.getString("categoryid"));
			redkart.setCategoryname(category.getString("categoryname"));
			redkart.setParentcategoryid(category.getString("parentcategoryid"));
			redkart.setCategoryimage(category.getBlob("categoryimage"));
			int img = (int) redkart.getCategoryimage().length();
			byte[] found= redkart.getCategoryimage().getBytes(1, img);
			String pick = Base64.getEncoder().encodeToString(found);
			redkart.setImage(pick);
			 kartBean1.add(redkart);
		}
		return  kartBean1;
	}

	@Override
	public List<KartBean> getSubCategory(String id) throws SQLException {
		String query = "Select* from categorytyp where parentcategoryid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, id);
		ResultSet subcategory = pstmt.executeQuery();
		List<KartBean> kartBean2 = new ArrayList<>();
		while ( subcategory.next()) {
			KartBean redkart = new KartBean();
			redkart.setCategoryid( subcategory.getString("categoryid"));
			redkart.setCategoryname( subcategory.getString("categoryname"));
			redkart.setCategoryimage( subcategory.getBlob("categoryimage"));
			int img = (int) redkart.getCategoryimage().length();
			byte[] fix = redkart.getCategoryimage().getBytes(1, img);
			String pick = Base64.getEncoder().encodeToString(fix);
			redkart.setImage(pick);
			kartBean2.add(redkart);
		}
		return kartBean2;
	}

	@Override
	public List<KartBean> getbrand(String id) throws SQLException {
		String query ="select * from categorytyp where parentcategoryid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, id);
		ResultSet brand = pstmt.executeQuery();
		List<KartBean>kartBean3 = new ArrayList<>();
		while (brand.next()) {
			KartBean redkart = new KartBean();
			redkart.setCategoryid(brand.getString("categoryid"));
			redkart.setCategoryname(brand.getString("categoryname"));
			redkart.setCategoryimage(brand.getBlob("categoryimage"));
			int img = (int) redkart.getCategoryimage().length();
			byte[] fix = redkart.getCategoryimage().getBytes(1, img);
			String photo = Base64.getEncoder().encodeToString(fix);
			redkart.setBrandpick(photo);
			kartBean3.add(redkart);
	}
		return kartBean3;
	}
}