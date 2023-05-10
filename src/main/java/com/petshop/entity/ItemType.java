package com.petshop.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemType {
		private String item_id;
		private String name;
		private List<TypeOfCategory> typeOfCategoryList;
		
		
		public ItemType() {

		}
		public ItemType(ItemType itemType) {
			this.item_id = itemType.item_id;
			this.name = itemType.name;
			this.typeOfCategoryList =new ArrayList<>(itemType.typeOfCategoryList);
		}
		public ItemType(String item_id, String name,List<TypeOfCategory> TypeOfProductList) {
			this.item_id = item_id;
			this.name = name ;
			this.typeOfCategoryList  =new ArrayList<>(TypeOfProductList);
		}
		public void setTypeOfCategoryList(List<TypeOfCategory> typeOfCategoryList) {
			this.typeOfCategoryList = new ArrayList<>(typeOfCategoryList) ;
		}
		public List<TypeOfCategory> getTypeOfCategoryList() {
			return this.typeOfCategoryList;
		}
		
		public String getItem_id() {
			return item_id;
		}

		public void setItem_id(String item_id) {
			this.item_id = item_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}	
}
