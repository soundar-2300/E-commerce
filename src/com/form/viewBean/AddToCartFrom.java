package com.form.viewBean;

public class AddToCartFrom {
private int quantity;
private  int productId;
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
private CartBean cart;
public CartBean getCart() {
	return cart;
}
public void setCart(CartBean cart) {
	this.cart = cart;
} 
}
