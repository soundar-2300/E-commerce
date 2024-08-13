package com.form.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.form.dao.ProductDao;
import com.form.viewBean.AddToCartFrom;
import com.form.viewBean.CartBean;
import com.form.viewBean.ProductBean;
import com.form.viewBean.UserBean;
import com.form.viewBean.CartEntryBean;

public interface CartService {

	public boolean addToCart(AddToCartFrom add) throws SQLException;

	public CartBean getCart(String email) throws SQLException;

	public boolean createCart(String email, int toalQuantity, double toalAmount) throws SQLException;

	boolean CreateCartEntry(CartBean cartBean, AddToCartFrom add, ProductBean productBean, double totalCost)
			throws SQLException;

	boolean updateCart(int totalQuantity, double totalAmount, int cartId) throws SQLException;

	public CartBean getShowItems(String email) throws SQLException;
	
	public CartBean getCartdetails(String email) throws SQLException;
	
	public boolean updateQuantity (CartEntryBean entry) throws SQLException;

	public  boolean getdeleteprocess(Integer Id) throws SQLException;
	
	public CartEntryBean getonceproduct(int productId, int cartId) throws SQLException;
	

	public  boolean updateproduct(CartEntryBean cartentry) throws SQLException;
	
	

}
