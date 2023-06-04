package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ProductsDao;
import com.petshop.entity.Products;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductsDao productsDao;
	
	public Products GetDataProductByProductID(String product_id) {
		
		return productsDao.GetDataProductByProductID(product_id);
	}
	public String getStringProductCategory(String product_id) {
		
		return productsDao.getStringProductCategory(product_id);
	}

	@Override
	public List<Products> GetDataProductByProductCategoryID(String product_categ_id) {
		return productsDao.GetDataProductByProductCategoryID(product_categ_id);
	}
	public List<Products> GetDataProduct(){
		return productsDao.GetDataProduct();
	}
	@Override
	public int UpdateProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.UpdateProduct(products) ;
	}
	@Override
	public int DeleteProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.DeleteProduct(products) ;
	}
	@Override
	public int AddProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.AddProduct(products);
	}
	@Override
	public List<Products> GetDataProductPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return productsDao.GetDataProductPaginate(start,end);
	}
	@Override
	public String getStringProductNameByProductID(String product_id) {
		// TODO Auto-generated method stub
		return productsDao.getStringProductNameByProductID(product_id);
	}
	@Override
	public List<String> GetDataProductID(String product_categ_id) {
		// TODO Auto-generated method stub
		return productsDao.GetDataProductID(product_categ_id);
	}
	@Override
	public List<Products> SearchProducts(String productName) {
		// TODO Auto-generated method stub
		return productsDao.SearchProducts(productName);
	}
	@Override
	public List<Products> GetDataProductPaginateInSearchFeature(int start, int end, String productName) {
		// TODO Auto-generated method stub
		return productsDao.GetDataProductPaginateInSearchFeature(start, end, productName);
	}
	@Override
	public List<Products> GetDataProductLimit12(String item_id) {
		// TODO Auto-generated method stub
		return productsDao.GetDataProductLimit12(item_id);
	}
	@Override
	public List<Products> GetDataProductFilterByPrice(String item_id, long min, long max) {
		// TODO Auto-generated method stub
		return productsDao.GetDataProductFilterByPrice(item_id, min, max);
	}
	@Override
	public List<Products> findProductByProductCategory(String product_categ_id, String status) {
		// TODO Auto-generated method stub
		return productsDao.findProductByProductCategory(product_categ_id, status);
	}
	@Override
	public List<Products> findProductByProductCategoryIDPaginate(String product_categ_id, String status, int start,
			int totalPage, String sort) {
		// TODO Auto-generated method stub
		return productsDao.findProductByProductCategoryIDPaginate(product_categ_id, status, start, totalPage, sort);
	}
	

}
