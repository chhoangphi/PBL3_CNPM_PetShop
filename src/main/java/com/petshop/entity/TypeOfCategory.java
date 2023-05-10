package com.petshop.entity;

import java.util.ArrayList;
import java.util.List;

public class TypeOfCategory {
	private String item_id;
	private String type_id;
	private String type_name;
	private List<ProductCategory> productCategoryList;

	public TypeOfCategory() {

	}

	public TypeOfCategory(TypeOfCategory typeOfCategory) {
		this.item_id=typeOfCategory.item_id;
		this.type_id=typeOfCategory.type_id;
		this.type_name=typeOfCategory.type_name;
		this.productCategoryList=new ArrayList<>(typeOfCategory.productCategoryList);
	}

	public TypeOfCategory(String item_id, String type_id, List<ProductCategory> productCategoryList) {
		super();
		this.item_id = item_id;
		this.type_id = type_id;
		this.productCategoryList = productCategoryList;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public List<ProductCategory> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<ProductCategory> productCategoryList) {
		this.productCategoryList = new ArrayList<>(productCategoryList);
	}
//	public List<Products> getProductsList() {
//		return ProductsList;
//	}
//	public void setProductsList(List<Products> ProductsList) {
//		this.ProductsList = new ArrayList<>(ProductsList);
//	}
}
