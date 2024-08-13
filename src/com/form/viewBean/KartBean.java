package com.form.viewBean;

import java.sql.Blob;

public class KartBean {
	private String categoryid;
	private String categoryname;
	private Blob categoryimage;
	private String image;
	private String parentcategoryid;
	private String parentname;
	private String brandpick;

	public String getBrandpick() {
		return brandpick;
	}

	public void setBrandpick(String brandpick) {
		this.brandpick = brandpick;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategoryid() {

		return categoryid;
	}

	public void setCategoryid(String string) {
		this.categoryid = string;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getParentcategoryid() {
		return parentcategoryid;
	}

	public void setParentcategoryid(String string) {
		this.parentcategoryid = string;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentcategoryname(String parentcategoryname) {
		this.parentname = parentcategoryname;

	}

	public Blob getCategoryimage() {
		return categoryimage;
	}

	public void setCategoryimage(Blob blob) {
		this.categoryimage = blob;
	}

}