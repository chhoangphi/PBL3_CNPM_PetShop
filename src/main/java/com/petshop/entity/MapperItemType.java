package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.petshop.dao.TypeOfCategoryDao;

public class MapperItemType implements RowMapper<ItemType> {
	private TypeOfCategoryDao typeOfCategoryDao;
	public MapperItemType(TypeOfCategoryDao typeOfCategoryDao) {
		this.typeOfCategoryDao=typeOfCategoryDao;
	}
	public ItemType mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemType itemType= new ItemType();
		String item_id=rs.getString("item_id");
		itemType.setItem_id(item_id);
		itemType.setName(rs.getString("name"));
		itemType.setTypeOfCategoryList(typeOfCategoryDao.GetDataTypeOfCategoryList(item_id));
		return itemType;
	}
}
