
package com.form.viewBean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class UserBean {

	private String firstName;
	
	private String lastName;
	
	@Email
	@Pattern
	private String email;
	
	@Size(min=2, max=10)
	private String password;
	
	@Size(min=2, max=10)
	private String confirmPassword;
	
	@Digits(fraction = 1, integer = 10)
	private String mobile;
	
	private MultipartFile image;
	private String pic;
	private String flatno;
	private String Area;
	private int pincode;
	private String landmark;
	private String towncity;
	private String state;
	private String country;
 private OrderBean orderBean;
 private String addaddress;
			public String getAddaddress() {
	return addaddress;
}
public void setAddaddress(String addaddress) {
	this.addaddress = addaddress;
}
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getConfirmPassword() {
				return confirmPassword;
			}
			public void setConfirmPassword(String confirmPassword) {
				this.confirmPassword = confirmPassword;
			}
			public String getMobile() {
				return mobile;
			}
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}
			public MultipartFile getImage() {
				return image;
			}
			public void setImage(MultipartFile image) {
				this.image = image;
			}
			public String getPic() {
				return pic;
			}
			public void setPic(String pic) {
				this.pic = pic;
			}
			public String getFlatno() {
				return flatno;
			}
			public void setFlatno(String flatno) {
				this.flatno = flatno;
			}
			public String getArea() {
				return Area;
			}
			public void setArea(String area) {
				Area = area;
			}
			public int getPincode() {
				return pincode;
			}
			public void setPincode(int pincode) {
				this.pincode = pincode;
			}
			public String getLandmark() {
				return landmark;
			}
			public void setLandmark(String landmark) {
				this.landmark = landmark;
			}
			public String getTowncity() {
				return towncity;
			}
			public void setTowncity(String towncity) {
				this.towncity = towncity;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public OrderBean getOrderBean() {
				return orderBean;
			}
			public void setOrderBean(OrderBean orderBean) {
				this.orderBean = orderBean;
			}
			}

	
	

	
	