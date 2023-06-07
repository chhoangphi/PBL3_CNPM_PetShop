package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		List<String> data = _JdbcTemplate.queryForList(sql, String.class);

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
	public String GetMaxTypeID()
	{
		
		try {
			String sql = "SELECT id FROM type_of_category";
			List<String> data = _JdbcTemplate.queryForList(sql, String.class);
			int x = 0;
			
			int max = 0;
			
			// String tmp1 = id.substring(0, 4);
			for (String string : data) {
				x = Integer.parseInt(string.substring(5));
				System.out.println("x = " + x);
				if(string.substring(5)==null)
					x = 0;
				if (x > max)
					max = x;
			}
			max++;
			System.out.println("max = " + max);
			String tmp = Integer.toString(max);
			if (max < 10)
				tmp = "0" + tmp;
			return tmp;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public String GetMaxProduct_cageID()
	{
		
		try {
			String sql = "SELECT product_categ_id FROM product_categories";
			List<String> data = _JdbcTemplate.queryForList(sql, String.class);
			int x = 0;
			
			int max = 0;
			
			// String tmp1 = id.substring(0, 4);
			for (String string : data) {
				x = Integer.parseInt(string.substring(5));
				System.out.println("x = " + x);
				if(string.substring(5)==null)
					x = 0;
				if (x > max)
					max = x;
			}
			max++;
			System.out.println("max = " + max);
			String tmp = Integer.toString(max);
			if (max < 10)
				tmp = "00" + tmp;
			else if (max < 100)
				tmp = "0" + tmp;
			
			return tmp;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<String> GetDataTypeID()
	{
		
		try {
			String sql = "SELECT product_categ_id FROM product_categories";
			List<String> data = _JdbcTemplate.queryForList(sql, String.class);
			
			return data;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public int AddProductCategory(ProductCategory productCategory)
	{
		String sql="  INSERT INTO product_categories VALUES(?,?,?,?,?)";
		
		Object[] param= {
				productCategory.getProduct_categ_id(),
				productCategory.getProduct_categ_name(),
				productCategory.getProduct_categ_name(),
				productCategory.getType_id()
				,null
		};
		System.out.println(sql);
		int updatedRow=_JdbcTemplate.update(sql,param);
		return updatedRow;
	}
}
