package com.form.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.form.dao.CartDao;
import com.form.dao.ProductDao;
import com.form.service.CartService;
import com.form.viewBean.AddToCartFrom;
import com.form.viewBean.CartBean;
import com.form.viewBean.CartEntryBean;
import com.form.viewBean.ProductBean;
import com.form.viewBean.UserBean;

public class CartServiceImpl implements CartService {

	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	private String email = "gokul@gmail.com";
			

	@SuppressWarnings("unused")
	@Override
	public boolean addToCart(AddToCartFrom add) throws SQLException {
		int totalQuantity = 0;
		Double totalAmount = 0.00, totalCost = 0.00;
		CartBean cartBean = getCart(email);
		int cartId = cartBean.getCartId();
		if (cartBean != null) {
			
		} else {
			
			boolean create = createCart(email, totalQuantity, totalAmount);
		if(create) {
			
			
		}
		}
		int productId = add.getProductId();
		ProductBean productBean = productDao.getProductData(productId);
		
		CartEntryBean cartEntry = cartDao.getonceproduct(cartId, productId);
		if (cartEntry != null && cartEntry.getPrice() > 0) {
			cartEntry.setQuantity(add.getQuantity() + cartEntry.getQuantity());
			cartEntry.setTotalCost(cartEntry.getQuantity() * cartEntry.getPrice());
			boolean product = updateproduct(cartEntry);
		} else {
			boolean cartEntry1 = CreateCartEntry(cartBean, add, productBean, totalCost);
		}
		boolean cart = updateCart(totalQuantity, totalAmount, cartBean.getCartId());
		if (cart) {
		}

		return true;
	}

	@Override
	public CartBean getCart(String email) throws SQLException {

		return cartDao.getCart(email);
	}

	@Override
	public boolean createCart(String email, int totalQuantity, double totalAmount) throws SQLException {

		return cartDao.createCart(email, totalQuantity, totalAmount);
	}

	@Override
	public boolean CreateCartEntry(CartBean Bean, AddToCartFrom add, ProductBean items  , double totalCost)
			throws SQLException {
		totalCost = add.getQuantity() * items.getProductPrice();
		return cartDao.createCartEntry(Bean, add, items, totalCost);
	}

	@Override
	public boolean updateCart(int totalQuantity, double totalAmount, int cartId) throws SQLException {

		double totalCost = 0.00;
		List<CartEntryBean> cartEntryBean = cartDao.getCartEntry(cartId);
		if (cartEntryBean != null) {
			for (CartEntryBean rupees : cartEntryBean) {
				totalQuantity += rupees.getQuantity();
				totalCost = rupees.getQuantity() * rupees.getPrice();
				totalAmount += totalCost;
			}
		}
		return cartDao.updateCart(totalQuantity, totalAmount, cartId);
	}

	@Override
	public CartBean getShowItems(String email) throws SQLException {

		return cartDao.getShowItems(email);
	}

	@Override
	public CartBean getCartdetails(String email) throws SQLException {

		CartBean cartbean = new CartBean();
		cartbean = cartDao.getShowItems(email);
		List<CartEntryBean> cartEntryBean = cartDao.getCartEntry(cartbean.getCartId());
		for (CartEntryBean entry : cartEntryBean) {
			ProductBean productBean = productDao.getProductData(entry.getProductId());
			entry.setProd(productBean);
		}
		cartbean.setEntryBean(cartEntryBean);
		return cartbean;
	}

	@Override
	public boolean updateQuantity(CartEntryBean entry) throws SQLException {
		entry.setTotalCost(entry.getQuantity() * entry.getTotalCost());
		return cartDao.updateQuantity(entry);
	}

	@Override
	public boolean getdeleteprocess(Integer Id) throws SQLException {

		return cartDao.getdeleteprocess(Id);
	}

	@Override
	public CartEntryBean getonceproduct(int cartId, int productId) throws SQLException {

		return cartDao.getonceproduct(cartId, productId);
	}

	@Override
	public boolean updateproduct(CartEntryBean cartentry) throws SQLException {

		return cartDao.updateproduct(cartentry);
	}

	
}
