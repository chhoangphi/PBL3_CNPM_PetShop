package com.petshop.dto;

import com.petshop.entity.Products;

public class CartDto {
		private int quantity;
		private long totalPrice;
		private Products product;
		public CartDto() {
			
		}
		public CartDto(int quantity, long totalPrice, Products product) {
			super();
			this.quantity = quantity;
			this.totalPrice = totalPrice;
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public long getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(long totalPrice) {
			this.totalPrice = totalPrice;
		}
		public Products getProduct() {
			return product;
		}
		public void setProduct(Products product) {
			this.product = product;
		}
		
}
