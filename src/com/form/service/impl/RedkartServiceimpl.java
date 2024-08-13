package com.form.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.form.dao.RedkartDao;
import com.form.service.RedkartService;
import com.form.viewBean.KartBean;

public class RedkartServiceimpl  implements RedkartService{
 
	private RedkartDao kartDao;

	public RedkartDao getKartDao() {
		return kartDao;
	}

	public void setKartDao(RedkartDao kartDao) {
		this.kartDao = kartDao;
	}

	@Override
	public List<KartBean> getcategory(KartBean kartBean) throws SQLException {
	
		return kartDao.getcategory(kartBean);
	}

	@Override
	public List<KartBean> getSubCategory(String id) throws SQLException {
	
		return this. kartDao.getSubCategory(id);
	}

	@Override
	public List<KartBean> getbrand(String id) throws SQLException {
		
		return this.kartDao.getbrand(id);
	}

	

	
}
