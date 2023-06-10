package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entity.ItemType;
import com.petshop.entity.Menus;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.TypeOfCategory;
import com.petshop.dao.ItemTypeDao;
import com.petshop.dao.MenuDao;
import com.petshop.dao.ProductCategoryDao;
import com.petshop.dao.TypeOfCategoryDao;

@Service
public class HomeServiceImpl implements IHomeService{
   @Autowired
    private ItemTypeDao itemTypeDao;
   @Autowired
   private MenuDao menuDao;
   @Autowired
   private TypeOfCategoryDao typeDao;
   @Autowired
   private ProductCategoryDao categoryDao;

	public List<ItemType> GetDataItemType() {
		return itemTypeDao.GetDataItemType();
	} 
	public List<Menus> GetDataMenu() {
		return menuDao.GetDataMenu();
	} 
	public List<TypeOfCategory> GetDataTypeOfCategoryList(String item_id) {
		return typeDao.GetDataTypeOfCategoryList(item_id);
	}
	public ItemType GetDataItemTypeByItemID(String item_id) {
		return itemTypeDao.GetDataItemTypeByItemID(item_id);
	}
	
	@Override
	public TypeOfCategory GetDataTypeOfCategory(String type_id) {
		return typeDao.GetDataTypeOfCategory(type_id);
	}
	@Override
	public ProductCategory GetDataProductCategory(String product_categ_id) {
		return categoryDao.GetDataProductCategory(product_categ_id);
	}
	@Override
	public String GetMaxMenuID() {
		// TODO Auto-generated method stub
		return menuDao.GetMaxMenuID();
	}
	@Override
	public int AddMenu(Menus menu) {
		// TODO Auto-generated method stub
		return menuDao.AddMenu(menu);
	}


}
