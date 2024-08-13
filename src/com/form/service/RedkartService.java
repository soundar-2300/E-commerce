package com.form.service;

import java.sql.SQLException;
import java.util.List;

import com.form.viewBean.KartBean;

public interface RedkartService {




	List<KartBean> getcategory(KartBean kartBean) throws SQLException;
	
	 List <KartBean> getSubCategory(String id)throws SQLException;
	 List<KartBean> getbrand(String id) throws SQLException;
}
