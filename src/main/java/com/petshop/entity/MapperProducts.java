package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProducts implements RowMapper<Products>{

	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		products.setProduct_id(rs.getString("product_id"));
		products.setProduct_name(rs.getString("product_name"));
		products.setImg(rs.getString("img"));
		products.setPrice(rs.getLong("price"));
		products.setDescription(rs.getString("description"));
		products.setProduct_categ_id(rs.getString("product_categ_id"));
		products.setSold_quantity(rs.getInt("sold_quantity"));
		products.setAmountOfProducts(rs.getInt("amountOfProducts"));
		products.setStatus(rs.getInt("status"));
		return products;
	}
	
}
