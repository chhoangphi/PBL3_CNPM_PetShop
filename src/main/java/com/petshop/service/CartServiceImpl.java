package com.petshop.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.CartDao;
import com.petshop.dto.CartDto;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private CartDao cartDao;
	public HashMap<String, CartDto> AddCart(String product_id, HashMap<String, CartDto> cart) {
		return cartDao.AddCart(product_id, cart);
	}

	@Override
	public HashMap<String, CartDto> EditCard(String product_id, int quantity, HashMap<String, CartDto> cart) {
	
		return cartDao.EditCard(product_id, quantity, cart);
	}

	@Override
	public HashMap<String, CartDto> DeleteCard(String product_id, HashMap<String, CartDto> cart) {
		return cartDao.DeleteCard(product_id, cart);
	}

	@Override
	public int TotalQuantity(HashMap<String, CartDto> cart) {
		return cartDao.TotalQuantity(cart);
	}

	@Override
	public long TotalPrice(HashMap<String, CartDto> cart) {
		return cartDao.TotalPrice(cart);
	}

}
