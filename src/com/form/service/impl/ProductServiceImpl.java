package com.form.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.form.dao.ProductDao;
import com.form.service.ProductService;
import com.form.viewBean.ProductBean;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<ProductBean> productList(int id) throws SQLException {
	
		return productDao.productList(id);
	}

	@Override
	public ProductBean getdescription(int id) throws SQLException {
	
		return productDao.getdescription(id);
	}

	


}
