package com.form.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import com.form.dao.ProductDao;
import com.form.viewBean.ProductBean;

public class ProductDaoImpl implements ProductDao {
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ProductBean> productList(int id) throws SQLException {
		String query = "select * from producttable where categoryid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet product = pstmt.executeQuery();
		List<ProductBean> productBean1= new ArrayList<>();
		while (product.next()) {
			ProductBean productBean = new ProductBean();
			productBean.setProductId(product.getInt("productId"));
			productBean.setProductName(product.getString("productName"));
			productBean.setProductImage(product.getBlob("productImage"));
			productBean.setProductColor(product.getString("productColor"));
			int blob = (int) productBean.getProductImage().length();
			byte[] art = productBean.getProductImage().getBytes(1, blob);
			String sigture = Base64.getEncoder().encodeToString(art);
			productBean.setPic(sigture);
			productBean.setProductPrice(product.getDouble("productPrice"));
			productBean1.add(productBean);
		}

		return productBean1;
	}

	@Override
	public ProductBean getdescription(int id) throws SQLException {
		String query = "select * from producttable where productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet product = pstmt.executeQuery();
		ProductBean productBean = new ProductBean();
		if (product.next()) {
			productBean.setProductId(product.getInt("productId"));
			productBean.setProductName(product.getString("productName"));
			productBean.setProductImage(product.getBlob("productImage"));
			productBean.setProductModel(product.getString("productModel"));
			productBean.setProductPrice(product.getDouble("productPrice"));
			productBean.setProductColor(product.getString("productcolor"));
			productBean.setProductSize(product.getString("productSize"));
			productBean.setProductOffer(product.getString("productOffer"));
			productBean.setProductSeller(product.getString("productSeller"));
			byte[] pic = product.getBytes("productImage");
			String flow = Base64.getEncoder().encodeToString(pic);
			productBean.setPic(flow);
		}
		return productBean;
	}

	@Override
	public ProductBean getProductData(int productId) throws SQLException {
		String query = "select * from producttable where productid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, productId);
		ResultSet description = pstmt.executeQuery();
		ProductBean productBean = new ProductBean();
		if (description.next()) {
			productBean.setProductId(description.getInt("productId"));
			productBean.setProductName(description.getString("productName"));
			productBean.setProductPrice(description.getDouble("productPrice"));
			productBean.setProductImage(description.getBlob("productImage"));
			byte[] art = description.getBytes("productImage");
			String connet = Base64.getEncoder().encodeToString(art);
			productBean.setPic(connet);
		}

		return productBean;
	}
}
