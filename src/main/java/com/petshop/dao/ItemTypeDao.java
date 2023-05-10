package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperItemType;
import com.petshop.entity.ItemType;

@Repository
public class ItemTypeDao extends BaseDao {
	@Autowired
	private TypeOfCategoryDao typeOfCategoryDao;
		public List<ItemType> GetDataItemType(){
			List<ItemType> list =new ArrayList<ItemType>();
			String sql="SELECT * FROM items_type";
			list=_JdbcTemplate.query(sql,new MapperItemType(typeOfCategoryDao));
			return list;
		}
		public ItemType GetDataItemTypeByItemID(String item_id){
			ItemType item =new ItemType();
			String sql="SELECT * FROM items_type WHERE item_id="+"'"+item_id+"'";
			item=_JdbcTemplate.queryForObject(sql,new MapperItemType(typeOfCategoryDao));
			return item;
		}
		
}
