package com.petshop.entity;

public class Products {
	private String product_id;
	private String product_name;
	private String img;
	private long price;
	private String description;
	private String product_categ_id;
	
	public Products() {
		super();
	}
	public Products(Products product) {
		super();
		this.product_id = product.product_id;
		this.product_name = product.product_name;
		this.img = product.img;
		this.price =product.price;
		this.description = product.description;
		this.product_categ_id = product.product_categ_id;
	}
	public Products(String product_id, String product_name, String img, long price, String description,
			String product_categ_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.img = img;
		this.price = price;
		this.description = description;
		this.product_categ_id = product_categ_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduct_categ_id() {
		return product_categ_id;
	}

	public void setProduct_categ_id(String product_categ_id) {
		this.product_categ_id = product_categ_id;
	}
	
}
