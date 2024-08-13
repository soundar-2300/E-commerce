package com.form.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.form.dao.CartDao;
import com.form.viewBean.AddToCartFrom;
import com.form.viewBean.CartBean;
import com.form.viewBean.CartEntryBean;
import com.form.viewBean.ProductBean;
import com.form.viewBean.UserBean;

public class CartDaoImpl implements CartDao {

	private DataSource dataSource;


	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public CartBean getCart(String email) throws SQLException {
		String query = "Select * from  cart where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);

		ResultSet cart = pstmt.executeQuery();
		CartBean cartBean = new CartBean();
		if (cart.next()) {
			cartBean.setCartId(cart.getInt("cartId"));
			cartBean.setTotalQuantity(cart.getInt("totalQuantity"));
			cartBean.setTotalAmount(cart.getDouble("totalAmount"));
			cartBean.setCharges(cart.getDouble("charges"));
		}
		return cartBean;

	}

	@Override
	public boolean createCart(String email, int totalQuantity, double totalAmount) throws SQLException {

		String query = "INSERT into cart (email,totalQuantity,totalAmount)Values(?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setInt(2, totalQuantity);
		pstmt.setDouble(3, totalAmount);
		boolean create = pstmt.execute();
		if (create) {
			return true;
		}

		return false;
	}

	@Override
	public boolean createCartEntry(CartBean Bean, AddToCartFrom add, ProductBean productBean, double totalCost)
			throws SQLException {
		String query = "INSERT INTO cartentry(productId,quantity,Price,totalCost,cartId) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, add.getProductId());
		pstmt.setInt(2, add.getQuantity());
		pstmt.setDouble(3, productBean.getProductPrice());
		pstmt.setDouble(4, totalCost);
		pstmt.setInt(5, Bean.getCartId());
		int cartEntry1 = pstmt.executeUpdate();
		if (cartEntry1 > 0) {
			return true;
		}

		return false;
	}

	@Override
	public List<CartEntryBean> getCartEntry(int cartId) throws SQLException {
		String query = " select*from cartentry where cartId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartId);

		ResultSet reset = pstmt.executeQuery();
		List<CartEntryBean> cartEntryBean = new ArrayList<>();
		while (reset.next()) {
			CartEntryBean cartEntryBean1 = new CartEntryBean();
			cartEntryBean1.setId(reset.getInt("Id"));
			cartEntryBean1.setProductId(reset.getInt("productId"));
			cartEntryBean1.setQuantity(reset.getInt("quantity"));
			cartEntryBean1.setPrice(reset.getInt("Price"));
			cartEntryBean1.setTotalCost(reset.getDouble("totalCost"));
			cartEntryBean1.setCartId(reset.getInt("cartId"));
			cartEntryBean1.setRemove(reset.getInt("Id"));
			cartEntryBean.add(cartEntryBean1);

		}

		return cartEntryBean;
	}

	@Override
	public boolean updateCart(int totalQuantity, double totalAmount, int cartId) throws SQLException {
		String query = "Update cart set  totalQuantity = ? , totalAmount=? where cartId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, totalQuantity);
		pstmt.setDouble(2, totalAmount);
		pstmt.setInt(3, cartId);
		int cart = pstmt.executeUpdate();
		if (cart > 0) {
			return true;
		}

		return false;
	}

	@Override
	public CartBean getShowItems(String email) throws SQLException {
		String query = "Select * from cart where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);

		ResultSet resultset = pstmt.executeQuery();
		CartBean cartBean = new CartBean();
		if (resultset.next()) {
			cartBean.setEmail(resultset.getString("email"));
			cartBean.setTotalQuantity(resultset.getInt("totalQuantity"));
			cartBean.setTotalAmount(resultset.getDouble("totalAmount"));
			cartBean.setCartId(resultset.getInt("cartId"));
		}

		return cartBean;
	}

	@Override
	public boolean updateQuantity(CartEntryBean entry) throws SQLException {
		String query = "Update cartentry set quantity = ? , totalCost=? where cartId=? and productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);

		pstmt.setInt(1,entry.getQuantity());
		pstmt.setDouble(2, entry.getTotalCost());
		pstmt.setDouble(3, entry.getCartId());
		pstmt.setInt(4, entry.getProductId());
		int increase = pstmt.executeUpdate();
		if (increase > 0) {
			int totalQuantity=0, cartId=entry.getCartId();
			double totalCost, totalAmount = 0.00;
		List<CartEntryBean>bean=getCartEntry(cartId);
		if(bean!=null) {
			for(CartEntryBean entryBean:bean) {
				totalQuantity+=entryBean.getQuantity();
				totalCost=entryBean.getQuantity()*entryBean.getPrice();
				totalAmount+=totalCost;
			}
		}
		return updateCart(totalQuantity,totalAmount,cartId);
		
		}
		return false;
	}

	@Override
	public boolean getdeleteprocess(Integer Id) throws SQLException {
		String query = "delete  from cartentry where Id=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, Id);
		int set = pstmt.executeUpdate();
		if (set > 0) {

			return true;
		}
		return false;
	}

	@Override
	public CartEntryBean getonceproduct(int cartId, int productId) throws SQLException {
		String query = "select * from cartentry  where cartId=? and productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartId);
		pstmt.setInt(2, productId);
		ResultSet replace = pstmt.executeQuery();
		CartEntryBean cartentry = new CartEntryBean();
		if (replace.next()) {
			cartentry.setCartId(replace.getInt("cartId"));
			cartentry.setProductId(replace.getInt("productId"));
			cartentry.setQuantity(replace.getInt("quantity"));
			cartentry.setPrice(replace.getDouble("Price"));
		}
		return cartentry;

	}

	@Override
	public boolean updateproduct(CartEntryBean cartentry) throws SQLException {
		String query = "Update cartentry set quantity = ? ,totalCost=? where cartId=? and productId=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartentry.getQuantity());
		pstmt.setDouble(2, cartentry.getTotalCost());
		pstmt.setInt(4, cartentry.getProductId());
		pstmt.setDouble(3, cartentry.getCartId());
		int product = pstmt.executeUpdate();
		if (product > 0) {
			return true;
		}
		return false;
	}

	
}