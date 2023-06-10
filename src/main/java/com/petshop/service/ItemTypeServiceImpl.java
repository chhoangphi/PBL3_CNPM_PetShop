package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ItemTypeDao;
import com.petshop.entity.ItemType;
@Service
public class ItemTypeServiceImpl implements IItemTypeService{

	@Autowired
	private ItemTypeDao itemTypeDao;

	@Override
	public List<ItemType> GetDataItemType() {
		// TODO Auto-generated method stub
		return itemTypeDao.GetDataItemType();
	}

	@Override
	public String GetMaxItemID() {
		// TODO Auto-generated method stub
		return itemTypeDao.GetMaxItemID();
	}

	@Override
	public int AddItemType(ItemType itemType) {
		// TODO Auto-generated method stub
		return itemTypeDao.AddItemType(itemType);
	}
	
	
	

	

}
