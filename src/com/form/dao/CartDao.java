package com.form.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.form.viewBean.AddToCartFrom;
import com.form.viewBean.CartBean;
import com.form.viewBean.ProductBean;
import com.form.viewBean.UserBean;
import com.form.viewBean.CartEntryBean;

public interface CartDao {

	public CartBean getCart(String email) throws SQLException;

	public boolean createCart(String email, int totalQuantity, double toalAmount) throws SQLException;

	boolean createCartEntry(CartBean Bean, AddToCartFrom add, ProductBean item, double totalCost)
			throws SQLException;

	public List<CartEntryBean> getCartEntry(int cartId) throws SQLException;

	boolean updateCart(int totalQuantity, double totalAmount, int cartId) throws SQLException;

	public CartBean getShowItems(String email) throws SQLException;
	
	public boolean updateQuantity (CartEntryBean entry) throws SQLException;

	public boolean getdeleteprocess(Integer Id) throws SQLException;

	public CartEntryBean getonceproduct(int productId,int cartId) throws SQLException;

	public  boolean updateproduct(CartEntryBean cartentry) throws SQLException;
	
}

