package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperTypeOfCategory;
import com.petshop.entity.TypeOfCategory;

@Repository
public class TypeOfCategoryDao extends BaseDao{
	@Autowired
	private ProductCategoryDao categoryDao;
	public List<TypeOfCategory> GetDataTypeOfCategoryList(String item_id) {
		List<TypeOfCategory> list =new ArrayList<>();
		try {
			StringBuffer sql=new StringBuffer();
			sql.append("SELECT");
			sql.append(" it.item_id");
			sql.append(" ,tp.id AS type_id");
			sql.append(" ,tp.name AS type_name");
			sql.append(" FROM");
			sql.append(" items_type AS it");
			sql.append(" INNER JOIN");
			sql.append(" type_of_category AS tp");
			sql.append(" ON");
			sql.append(" it.item_id=tp.item_id");
			sql.append(" WHERE");
			sql.append(" it.item_id=");
			sql.append("'" + item_id + "'");
        	  System.out.println("SQL Query: "+sql);
        	  list=_JdbcTemplate.query(sql.toString(),new MapperTypeOfCategory(categoryDao));
      		return list;
        	}catch (Exception e) {
    			  System.out.println(e);
    			  return null; 
    			}
		
	}
	public TypeOfCategory GetDataTypeOfCategory(String type_id) {
		TypeOfCategory type =new TypeOfCategory();
		try {
			String sql="SELECT id AS type_id,name AS type_name ,item_id  FROM type_of_category WHERE id="+"'"+type_id+"'";
        	  System.out.println("SQL Query: "+sql);
        	  type=_JdbcTemplate.queryForObject(sql.toString(),new MapperTypeOfCategory(categoryDao));
      		return type;
        	}catch (Exception e) {
    			  System.out.println(e);
    			  return null; 
    			}
		
	}
	public List<TypeOfCategory> GetDataTypeOfCategory() {

		List<TypeOfCategory> listTypeOfCategory = new ArrayList<>();
		try {
			// String sql= " SELECT * FROM type_of_category ";
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
			sql.append(" tp.item_id");
			sql.append(" ,tp.id AS type_id");
			sql.append(" ,tp.name AS type_name");
			sql.append(" FROM type_of_category as tp");
			listTypeOfCategory = _JdbcTemplate.query(sql.toString(), new MapperTypeOfCategory(categoryDao));
			return listTypeOfCategory;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	public int AddTypeOfCategory(TypeOfCategory typeOfCategory)
	{
		String sql="  INSERT INTO type_of_category VALUES(?,?,?)";
		
		Object[] param= {
				typeOfCategory.getType_id(),
				typeOfCategory.getType_name(),
				typeOfCategory.getItem_id()
				
		};
		System.out.println(sql);
		int updatedRow=_JdbcTemplate.update(sql,param);
		return updatedRow;
	}
	
	
}
