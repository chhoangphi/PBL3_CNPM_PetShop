package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ProductCategoryDao;
import com.petshop.dao.ProductsDao;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;

@Service
public class CategoriesServiceImpl implements ICategoriesService {

	@Autowired
	private ProductCategoryDao categoryDao;
	@Autowired ProductsDao productDao;
	
	public List<ProductCategory> GetDataProductCategoryList(String type_id) {
		return categoryDao.GetDataProductCategoryList(type_id);
	}

	@Override
	public List<Products> GetDataProductByTypeIDLimit9(String type_id) {
		return productDao.GetDataProductByTypeIDLimit9(type_id);
	}
	@Override
	public List<Products> GetDataProductByTypeIDPaginate(String type_id,int start,int end) {
		return productDao.GetDataProductByTypeIDPaginate(type_id,start,end);
	}

	@Override
	public List<Products> GetDataProductByTypeID(String type_id) {
		// TODO Auto-generated method stub
		return productDao.GetDataProductByTypeID(type_id);
	}
	@Override
	public String GetProductCategoryNameByProductCateg_ID(String product_categ_id) {
		// TODO Auto-generated method stub
		return categoryDao.GetProductCategoryNameByProductCateg_ID(product_categ_id);
	}
	@Override
	public String getStringProductCategoryIDByName(String product_categ_name) {
		// TODO Auto-generated method stub
		return categoryDao.getStringProductCategoryIDByName(product_categ_name);
	}

	@Override
	public int UpdateProductCategoryID( String product_categ_id) {
		// TODO Auto-generated method stub
		return categoryDao.UpdateProductCategoryID(product_categ_id);
	}

	@Override
	public List<ProductCategory> GetAllDataProductCategory() {
		// TODO Auto-generated method stub
		return categoryDao.GetAllDataProductCategory();
	}
	
	@Override
	public List<Products> GetDataProductByProductCategoryIDPaginate(String product_categ_id, int start,
			int totalProductpage) {
		// TODO Auto-generated method stub
		return productDao.GetDataProductByProductCategoryIDPaginate(product_categ_id, start, totalProductpage);
	}

	@Override
	public List<String> GetDataProductCategoryNameList() {
		// TODO Auto-generated method stub
		return categoryDao.GetDataProductCategoryNameList();
	}

	

}
