package com.petshop.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.petshop.dto.CartDto;

@Service
public interface ICartService {
	public HashMap<String, CartDto> AddCart(String product_id,HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> EditCard(String product_id,int quantity,HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> DeleteCard(String product_id,HashMap<String, CartDto> cart);
	public int TotalQuantity(HashMap<String, CartDto> cart);
	public long TotalPrice(HashMap<String, CartDto> cart);
}
