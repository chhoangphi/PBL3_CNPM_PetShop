package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.petshop.dao.ProductsDao;

public class MapperProductCategory implements RowMapper<ProductCategory>{
	
	private ProductsDao productDao;
	public MapperProductCategory(ProductsDao productDao) {
		this.productDao=productDao;
	}
	
	public ProductCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductCategory productCategory=new ProductCategory();
		String product_categ_id=rs.getString("product_categ_id");
		productCategory.setProduct_categ_id(product_categ_id);
		productCategory.setProduct_categ_name(rs.getString("product_categ_name"));
		productCategory.setType_id(rs.getString("type_id"));
		productCategory.setImg(rs.getString("img"));
		productCategory.setProductList(productDao.GetDataProductByProductCategoryID(product_categ_id));
		return productCategory;
	}

}
