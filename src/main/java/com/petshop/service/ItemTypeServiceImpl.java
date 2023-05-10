package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ItemTypeDao;
import com.petshop.dao.ProductsDao;
import com.petshop.entity.ItemType;
import com.petshop.entity.Products;

@Service
public class ItemTypeServiceImpl implements IItemTypeService{

	@Autowired
	private ItemTypeDao itemTypeDao;

	@Override
	public List<ItemType> GetDataItemType() {
		// TODO Auto-generated method stub
		return itemTypeDao.GetDataItemType();
	}
	
	
	

	

}
