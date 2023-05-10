package com.petshop.entity;

import java.util.ArrayList;
import java.util.List;

public class Menus {
		private String menu_id;
		private String menu_name;
		private int order;
		private String item_id;
		private List<ItemType> itemTypeList;
		
		public String getItem_id() {
			return item_id;
		}
		public void setItem_id(String item_id) {
			this.item_id = item_id;
		}
		public Menus() {
			
		}
		public Menus(Menus menu) {
			super();
			this.menu_id = menu.menu_id;
			this.menu_name = menu.menu_name;
			this.order = menu.order;
			this.item_id = menu.item_id;
			this.itemTypeList = menu.itemTypeList;
		}
		public Menus(String menu_id, String menu_name, int order, String item_id, List<ItemType> itemTypeList) {
			super();
			this.menu_id = menu_id;
			this.menu_name = menu_name;
			this.order = order;
			this.item_id = item_id;
			this.itemTypeList = new ArrayList<>(itemTypeList);
		}
		public String getMenu_id() {
			return menu_id;
		}
		public void setMenu_id(String menu_id) {
			this.menu_id = menu_id;
		}
		public String getMenu_name() {
			return menu_name;
		}
		public void setMenu_name(String name) {
			this.menu_name = name;
		}
		
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public List<ItemType> getItemTypeList() {
			return itemTypeList;
		}
		public void setItemTypeList(List<ItemType> itemTypeList) {
			this.itemTypeList =new ArrayList<>(itemTypeList);
		}
		
}
