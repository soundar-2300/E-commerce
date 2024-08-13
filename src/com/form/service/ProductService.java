package com.form.service;

import java.sql.SQLException;
import java.util.List;

import com.form.viewBean.ProductBean;

public interface ProductService {

	List<ProductBean> productList(int id) throws SQLException;

	public ProductBean getdescription(int id) throws SQLException;




}
