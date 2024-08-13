package com.form.dao;

import java.sql.SQLException;
import java.util.List;

import com.form.viewBean.KartBean;

public interface RedkartDao {

	public List<KartBean> getcategory(KartBean KartBean) throws SQLException;

	public List<KartBean> getSubCategory(String id) throws SQLException;

	public List<KartBean> getbrand(String id) throws SQLException;
}