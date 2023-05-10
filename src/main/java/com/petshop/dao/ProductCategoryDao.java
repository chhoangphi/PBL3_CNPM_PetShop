package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperProductCategory;
import com.petshop.entity.ProductCategory;


@Repository
public class ProductCategoryDao extends BaseDao {
	@Autowired
	private ProductsDao productsDao;
	
	public String Sql(String type_id)
	{
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT");
		sql.append(" pdr.product_categ_name");
		sql.append(", pdr.product_categ_id");
		sql.append(", pdr.type_id");
		sql.append(" FROM");
		sql.append("  product_categories AS pdr");
		sql.append(" WHERE");
		sql.append(" pdr.type_id=");
		sql.append("'"+type_id+"'");
		return sql.toString();
	}
	public List<ProductCategory> GetDataProductCategoryList(String type_id) {
		List<ProductCategory> list =new ArrayList<>();
		try {
		      String sql=Sql(type_id);
        	  System.out.println("SQL Query: "+sql);
        	  list=_JdbcTemplate.query(sql.toString(),new MapperProductCategory(productsDao));
      		return list;
        	}catch (Exception e) {
    			  System.out.println(e);
    			  return null; 
    			}
	}
	public ProductCategory GetDataProductCategory(String product_categ_id) {
		ProductCategory productCategory =new ProductCategory();
		try {
		      String sql=" SELECT * FROM product_categories WHERE product_categ_id="+"'"+product_categ_id+"'";
        	  System.out.println("SQL Query: "+sql);
        	  productCategory=_JdbcTemplate.queryForObject(sql,new MapperProductCategory(productsDao));
      		return productCategory;
        	}catch (Exception e) {
    			  System.out.println(e);
    			  return null; 
    			}
	}
	public List<String> GetDataProductCategoryNameList() {
		// TODO Auto-generated method stub
		String sql = "SELECT product_categ_name from product_categories";
//		List<String> list =new ArrayList<>();
//		list =_JdbcTemplate.execute(sql, list));
//		//list=_JdbcTemplate.query(sql,new MapperProductCategory());
		List data = _JdbcTemplate.queryForList(sql, String.class);

		return data;
	}
	public String GetProductCategoryNameByProductCateg_ID(String product_categ_id) {
		// TODO Auto-generated method stub
		ProductCategory productCategory = new ProductCategory();
		String sql = "SELECT * from product_categories where product_categ_id ='"+product_categ_id+"'";
//		List<String> list =new ArrayList<>();
//		list =_JdbcTemplate.execute(sql, list));
//		//list=_JdbcTemplate.query(sql,new MapperProductCategory());
		productCategory = _JdbcTemplate.queryForObject(sql, new MapperProductCategory(productsDao));

		return productCategory.getProduct_categ_name();
	}

	public String getStringProductCategoryIDByName(String product_categ_name) {
		ProductCategory productCategory = new ProductCategory();
		String sql = "SELECT * FROM product_categories WHERE product_categ_name=" + "'"
				+ product_categ_name + "'";
		System.out.println("SQL Query: " + sql);
		productCategory = _JdbcTemplate.queryForObject(sql, new MapperProductCategory(productsDao));

		return productCategory.getProduct_categ_id();

	}

	public int UpdateProductCategoryID(String product_categ_id) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append("product_categories ");
		sql.append("SET ");
		sql.append("product_categ_id='" + product_categ_id);
		sql.append("'");
		int insert = _JdbcTemplate.update(sql.toString());
		return insert;
	}
	public List<ProductCategory> GetAllDataProductCategory() {
		List<ProductCategory> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM  product_categories ";
			System.out.println("SQL Query: " + sql);
			list = _JdbcTemplate.query(sql, new MapperProductCategory(productsDao));
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
