package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.petshop.dao.ProductCategoryDao;

public class MapperTypeOfCategory implements RowMapper<TypeOfCategory>{
	private ProductCategoryDao categoryDao;
	public MapperTypeOfCategory(ProductCategoryDao categoryDao) {
		this.categoryDao=categoryDao;
	}
	@Override
	public TypeOfCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

		TypeOfCategory types=new TypeOfCategory();
		String type_id=rs.getString("type_id");
		types.setType_id(type_id);
		types.setType_name(rs.getString("type_name"));
		types.setItem_id(rs.getString("item_id"));
		types.setProductCategoryList(categoryDao.GetDataProductCategoryList(type_id));
		return types;
	}

}
