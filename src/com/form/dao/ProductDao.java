package com.form.dao;

import java.sql.SQLException;
import java.util.List;

import com.form.viewBean.ProductBean;

public interface ProductDao {
	List<ProductBean> productList(int id) throws SQLException;

	public ProductBean getdescription(int id) throws SQLException;

	ProductBean getProductData(int productId) throws SQLException;


}
