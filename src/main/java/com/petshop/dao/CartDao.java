package com.petshop.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petshop.dto.CartDto;
import com.petshop.entity.Products;

@Repository
public class CartDao {
		@Autowired
		private ProductsDao productsDao;
		
		public HashMap<String, CartDto> AddCart(String product_id,HashMap<String, CartDto> cart) {
			CartDto itemCart=new CartDto();
			Products product=productsDao.GetDataProductByProductID(product_id);
			if (product!=null && cart.containsKey(product_id)) {
				
				itemCart = cart.get(product_id);
				itemCart.setQuantity(itemCart.getQuantity()+1);
				itemCart.setTotalPrice(product.getPrice()*itemCart.getQuantity());
			}
			else {
				itemCart.setProduct(product);
				itemCart.setQuantity(1);
				itemCart.setTotalPrice(product.getPrice());
			}
			cart.put(product_id, itemCart);
			return cart;
		}
		public HashMap<String, CartDto> EditCard(String product_id,int quantity,HashMap<String, CartDto> cart){
			if (cart==null) return cart;
			CartDto itemCart=new CartDto();
			if (cart.containsKey(product_id)) {
				itemCart=cart.get(product_id);
				itemCart.setQuantity(quantity);
				itemCart.setTotalPrice(quantity*itemCart.getProduct().getPrice());
			}
			cart.put(product_id, itemCart);
			return cart;
		}
		public HashMap<String, CartDto> DeleteCard(String product_id,HashMap<String, CartDto> cart){
			if (cart==null) return cart;
			if (cart.containsKey(product_id)) cart.remove(product_id);
			return cart;
		}
		public int TotalQuantity(HashMap<String, CartDto> cart) {
			int totalQuantity=0;
			for (Map.Entry<String, CartDto> itemCart : cart.entrySet() ) {
				totalQuantity+=itemCart.getValue().getQuantity();
			}
			return totalQuantity;
		}
		public long TotalPrice(HashMap<String, CartDto> cart) {
			long totalPrice=0;
			for (Map.Entry<String, CartDto> itemCart : cart.entrySet() ) {
				totalPrice+=itemCart.getValue().getTotalPrice();
			}
			return totalPrice;
		}
}
