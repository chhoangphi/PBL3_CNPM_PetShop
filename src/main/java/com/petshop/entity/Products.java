package com.petshop.entity;

public class Products {
	private String product_id;
	private String product_name;
	private String img;
	private long price;
	private String description;
	private String product_categ_id;
	private int status;
	private int sold_quantity;
	private int amountOfProducts;
	
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
		this.status = 1;
		this.sold_quantity = product.sold_quantity;
		this.amountOfProducts = product.amountOfProducts;

	}
	public Products(String product_id, String product_name, String img, long price, String description,
			String product_categ_id,int status,int sold_quantity,int amountOfProducts) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.img = img;
		this.price = price;
		this.description = description;
		this.product_categ_id = product_categ_id;
		this.status = 1;
		this.sold_quantity = sold_quantity;
		this.amountOfProducts = amountOfProducts;
		
	}

	public int getAmountOfProducts() {
		return amountOfProducts;
	}
	public void setAmountOfProducts(int amountOfProducts) {
		this.amountOfProducts = amountOfProducts;
	}
	public int getSold_quantity() {
		return sold_quantity;
	}
	public void setSold_quantity(int sold_quantity) {
		this.sold_quantity = sold_quantity;
	}
	public String getProduct_id() {
		return product_id;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
		//this.status = 0;
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
