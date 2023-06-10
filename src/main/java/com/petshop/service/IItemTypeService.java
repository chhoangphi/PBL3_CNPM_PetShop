package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.ItemType;

@Service
public interface IItemTypeService {
	public List<ItemType> GetDataItemType(); 
	public String GetMaxItemID();
	public int AddItemType(ItemType itemType);
	
}
