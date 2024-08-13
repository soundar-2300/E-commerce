package com.form.viewBean;

public class CartEntryBean {
private Integer Id;
private  int productId;
private int quantity;
private double price;
private double totalCost;
private int cartId;
private int remove;

public int getRemove() {
	return remove;
}
public void setRemove(int remove) {
	this.remove = remove;
}
private ProductBean prod;
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getTotalCost() {
	return totalCost;
}
public void setTotalCost(double totalCost) {
	this.totalCost = totalCost;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public ProductBean getProd() {
	return prod;
}
public void setProd(ProductBean prod) {
	this.prod = prod;
}
}
