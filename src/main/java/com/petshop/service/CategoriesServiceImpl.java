package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ProductCategoryDao;
import com.petshop.dao.ProductsDao;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
@Service
public class CategoriesServiceImpl implements ICategoriesService {

	@Autowired
	private ProductCategoryDao categoryDao;
	@Autowired ProductsDao productDao;
	
	public List<ProductCategory> GetDataProductCategoryList(String type_id) {
		return categoryDao.GetDataProductCategoryList(type_id);
	}

	@Override
	public List<Products> GetDataProductByTypeIDLimit8(String type_id,String sort) {
		return productDao.GetDataProductByTypeIDLimit8(type_id,sort);
	}
	@Override
	public List<Products> GetDataProductByTypeIDPaginate(String type_id,int start,int end,String sort) {
		return productDao.GetDataProductByTypeIDPaginate(type_id,start,end,sort);
	}

	@Override
	public List<Products> GetDataProductByTypeID(String type_id,String sort) {
		// TODO Auto-generated method stub
		return productDao.GetDataProductByTypeID(type_id,sort);
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
			int totalProductpage,String sort) {
		// TODO Auto-generated method stub
		return productDao.GetDataProductByProductCategoryIDPaginate(product_categ_id, start, totalProductpage,sort);
	}

	@Override
	public List<String> GetDataProductCategoryNameList() {
		// TODO Auto-generated method stub
		return categoryDao.GetDataProductCategoryNameList();
	}

	@Override
	public List<ProductCategory> GetFeaturedCategory() {
		// TODO Auto-generated method stub
		return categoryDao.GetFeaturedCategory();
	}

	@Override
	public List<ProductCategory> GetFeaturedCategoryByItemId(String item_id) {
		// TODO Auto-generated method stub
		return categoryDao.GetFeaturedCategoryByItemId(item_id);
	}

	@Override 
	public String GetMaxProduct_cageID() {
		// TODO Auto-generated method stub
		return categoryDao.GetMaxProduct_cageID();
	}

	@Override
	public String GetMaxTypeID() {
		// TODO Auto-generated method stub
		return categoryDao.GetMaxTypeID();
	}
	@Override
	public List<String> GetDataTypeID() {
		// TODO Auto-generated method stub
		return categoryDao.GetDataTypeID();
	}

	@Override
	public int AddProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return categoryDao.AddProductCategory(productCategory);
	}

	

}
