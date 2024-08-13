package com.form.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.form.dao.CartDao;
import com.form.dao.OrderDao;
import com.form.dao.ProductDao;
import com.form.dao.UserDao;
import com.form.service.OrderService;
import com.form.viewBean.CartBean;
import com.form.viewBean.CartEntryBean;
import com.form.viewBean.OrderBean;
import com.form.viewBean.ProductBean;
import com.form.viewBean.UserBean;

public class OrderServiceImpl implements OrderService {
	private String email = "gokul@gmail.com";
	private OrderDao orderDao;
	private CartDao cartDao;
	private ProductDao productDao;
	private UserDao userDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserBean ordercheckout(String email) throws SQLException {

		return userDao.userInfo(email);
	}
	
	@Override
	public CartBean totalpayment(String email) throws SQLException {
	
		return orderDao.totalpayment(email);
	}

	@Override
	public Boolean submitdatas(OrderBean orderBean) throws SQLException {

		return orderDao.submitdatas(orderBean);
	}

	@Override
	public OrderBean getDetailSummary(String email) throws SQLException {
		OrderBean orderBean = new OrderBean();
		UserBean userBean = userDao.userInfo(email);
		CartBean cartBean = cartDao.getCart(email);
		cartBean = orderDao.totalpayment(email);
		orderBean = orderDao.getsummarydatas(email);
		orderBean.setCartBean(cartDao.getCart(email));
		List<CartEntryBean> entryBean = cartDao.getCartEntry(orderBean.getCartBean().getCartId());
		for (CartEntryBean entryBean1 : entryBean) {
			ProductBean productBean = productDao.getProductData(entryBean1.getProductId());
			entryBean1.setProd(productBean);
		}
		orderBean.setCartBean(cartBean);
		orderBean.setCartBean(cartBean);
		orderBean.setEntryBean(entryBean);
		orderBean.setUserBean(userBean);
		orderBean.setEntryBean(entryBean);

		return orderBean;
	}

	@Override
	public OrderBean getsummarydatas(String email) throws SQLException {

		return orderDao.getsummarydatas(email);
	}

	
}
