package com.petshop.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
	 private String product_categ_id;
	 private String product_categ_name;
	 private String type_id;
	 private String img;
	 private List<Products> productList;
	
	public ProductCategory() {
		
	}
	
	public ProductCategory(String product_categ_id, String product_categ_name, String type_id,
			List<Products> productList) {
		super();
		this.product_categ_id = product_categ_id;
		this.product_categ_name = product_categ_name;
		this.type_id = type_id;
		this.productList = productList;
	}
	public ProductCategory(ProductCategory productCategory) {
		super();
		this.product_categ_id = productCategory.product_categ_id;
		this.product_categ_name = productCategory.product_categ_name;
		this.type_id = productCategory.type_id;
		this.productList = new ArrayList<>(productCategory.productList) ;
	}
	public void setProduct_categ_id(String product_catg_id) {
		this.product_categ_id = product_catg_id;
	}
	public String getProduct_categ_name() {
		return product_categ_name;
	}
	public void setProduct_categ_name(String product_catg_name) {
		this.product_categ_name = product_catg_name;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public List<Products> getProductList() {
		return productList;
	}
	public void setProductList(List<Products> productList) {
		this.productList =new ArrayList<>(productList);
	}
	public String getProduct_categ_id() {
		return product_categ_id;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
