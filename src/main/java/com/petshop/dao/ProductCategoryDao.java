package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.petshop.entity.MapperProductCategory;
import com.petshop.entity.MapperProducts;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;


@Repository
public class ProductCategoryDao extends BaseDao {
	@Autowired
	private ProductsDao productsDao;
	
	public String Sql(String type_id)
	{
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT");
		sql.append(" pdr.*");
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
	public List<ProductCategory> GetFeaturedCategory(){
		try {
	        String sql = "SELECT pdc.* FROM product_categories AS pdc INNER JOIN products AS pd\n"
	                + "ON pd.product_categ_id=pdc.product_categ_id GROUP BY pdc.product_categ_id ORDER BY SUM(pd.sold_quantity) DESC LIMIT 0,6";
	        System.out.println("SQL Query: " + sql);
	        List<ProductCategory> list = _JdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductCategory.class));
	        return list;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}
	public List<ProductCategory> GetFeaturedCategoryByItemId(String item_id){
		try {
	        String sql = "SELECT pdc.* FROM product_categories AS pdc INNER JOIN products AS pd\n"
	        		+ "ON pd.product_categ_id=pdc.product_categ_id INNER JOIN type_of_category AS typeof ON\n"
	        		+ "typeof.id=pdc.type_id INNER JOIN  items_type AS it ON\n"
	        		+ "it.item_id=typeof.item_id WHERE it.item_id=? GROUP BY pdc.product_categ_id ORDER BY SUM(pd.sold_quantity) DESC LIMIT 0,8";
	        Object param=item_id;
	        List<ProductCategory> list = _JdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductCategory.class),param);
	        return list;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}
//	public String getTypeIdByProductCateg_id(String product_categ_id)
//	{
//		Products product = new Products();
//		try {
//			String sql = "SELECT * FROM products WHERE product_categ_id=" + "'" + product_id + "'";
//			product = _JdbcTemplate.queryForObject(sql, new MapperProducts());
//			System.out.println("SQL Query: " + sql);
//			return product.getProduct_categ_id();
//		} catch (Exception e) {
//			System.out.println(e);
//			return null;
//		}
//	}
}
