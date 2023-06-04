package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.Products;

@Service
public interface IProductService {
	public Products GetDataProductByProductID(String product_id);
	public String getStringProductCategory(String product_id);
	public List<Products> GetDataProductByProductCategoryID(String product_categ_id);
	public List<Products> GetDataProduct(); 
	public int UpdateProduct(Products products);
	public int DeleteProduct(Products products);
	public int AddProduct(Products products);
	public List<Products> GetDataProductPaginate(int start,int end);
	public String getStringProductNameByProductID(String product_id) ;
	public List<String> GetDataProductID(String product_categ_id);
	public List<Products> SearchProducts(String productName);
	public List<Products> GetDataProductPaginateInSearchFeature(int start, int end, String productName);
	public List<Products> GetDataProductLimit12(String item_id);
	public List<Products> GetDataProductFilterByPrice(String item_id,long min,long max);
	public List<Products> findProductByProductCategory(String product_categ_id,String status);
	public List<Products> findProductByProductCategoryIDPaginate(String product_categ_id,String status,int start, int totalPage,String sort);
}


