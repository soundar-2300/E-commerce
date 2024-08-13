package com.form.viewBean;
import java.sql.Timestamp;
import java.util.List;

public class CartBean {
	private int cartId;
	private String email;
	private int totalQuantity;
	private double totalAmount; 
	private String address;
	private String address2;
	private int pincode;
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	private String paymentmethod;
	private Double charges;
	private Double payout;
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	private Timestamp datetime;
	public Double getPayout() {
		return payout;
	}
	public void setPayout(Double payout) {
		this.payout = payout;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	private Timestamp placetime;
	
	public Timestamp getPlacetime() {
		return placetime;
	}
	public void setPlacetime(Timestamp placetime) {
		this.placetime = placetime;
	}
		private int iD;
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

private List <CartEntryBean> entryBean;

	public List<CartEntryBean> getEntryBean() {
		return entryBean;
	}
	public void setEntryBean(List<CartEntryBean> entryBean) {
		this.entryBean = entryBean;
	}
	
	}
	
