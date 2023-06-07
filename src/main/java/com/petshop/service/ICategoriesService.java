package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;

@Service
public interface ICategoriesService {
//	public List<TypeOfCategory> GetDataTypeOfCategoryByID(ItemType itemType);
	public List<ProductCategory> GetDataProductCategoryList(String type_id);
	public List<Products> GetDataProductByTypeID(String type_id,String sort);
	public List<Products> GetDataProductByTypeIDPaginate(String type_id,int start,int end,String sort);
	public List<Products> GetDataProductByTypeIDLimit8(String type_id,String sort);
	public List<String> GetDataProductCategoryNameList();
	public String GetProductCategoryNameByProductCateg_ID(String product_categ_id);
	public String getStringProductCategoryIDByName(String product_categ_name);
	public int UpdateProductCategoryID(String product_categ_id);
	public List<ProductCategory> GetAllDataProductCategory();
	public List<Products> GetDataProductByProductCategoryIDPaginate(String product_categ_id,int start,int totalProductpage,String sort);
	public List<ProductCategory> GetFeaturedCategory();
	public List<ProductCategory> GetFeaturedCategoryByItemId(String item_id);
	public String GetMaxProduct_cageID();
	public String GetMaxTypeID();
	public List<String> GetDataTypeID();
	public int AddProductCategory(ProductCategory productCategory);

	

	
}
