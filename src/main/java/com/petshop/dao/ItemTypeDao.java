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
		public String GetMaxItemID()
		{
			try {
				String sql = "SELECT item_id FROM items_type";
				List<String> data = _JdbcTemplate.queryForList(sql, String.class);
				int x = 0;
				
				int max = 0;
				
				// String tmp1 = id.substring(0, 4);
				for (String string : data) {
					x = Integer.parseInt(string.substring(4));
					if(string.substring(4)==null)
						x = 0;
					if (x > max)
						max = x;
				}
				max++;
				String tmp = Integer.toString(max);
				if (max < 10)
					tmp = "0" + tmp;
				
				return tmp;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		public int AddItemType(ItemType itemType)
		{
			String sql="  INSERT INTO items_type VALUES(?,?)";
			
			Object[] param= {
					itemType.getItem_id(),
					itemType.getName()
					
					
			};
			int updatedRow=_JdbcTemplate.update(sql,param);
			return updatedRow;
		}
		
}
