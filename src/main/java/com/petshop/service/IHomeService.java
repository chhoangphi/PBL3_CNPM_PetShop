package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.ItemType;
import com.petshop.entity.Menus;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.TypeOfCategory;

@Service
public interface IHomeService {

	public List<ItemType> GetDataItemType();
	public List<Menus> GetDataMenu();
	public ItemType GetDataItemTypeByItemID(String item_id);
	public TypeOfCategory GetDataTypeOfCategory(String type_id);
	public ProductCategory GetDataProductCategory(String product_categ_id);
	public String GetMaxMenuID();
	public int AddMenu(Menus menu);
}
