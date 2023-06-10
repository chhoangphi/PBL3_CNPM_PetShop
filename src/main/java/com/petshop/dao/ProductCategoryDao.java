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
	
	public List<ProductCategory> GetDataProductCategoryList(String type_id) {
		List<ProductCategory> list =new ArrayList<>();
		try {
			String sql = "SELECT * FROM product_categories WHERE type_id = ?";
			Object[] param = { type_id };
			list = _JdbcTemplate.query(sql, new MapperProductCategory(productsDao), param);
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public ProductCategory GetDataProductCategory(String product_categ_id) {
		ProductCategory productCategory =new ProductCategory();
		try {
		      String sql=" SELECT * FROM product_categories WHERE product_categ_id="+"'"+product_categ_id+"'";
        	  productCategory=_JdbcTemplate.queryForObject(sql,new MapperProductCategory(productsDao));
      		return productCategory;
        	}catch (Exception e) {
    			  System.out.println(e);
    			  return null; 
    			}
	}
	public List<String> GetDataProductCategoryNameList() {
		try {
		String sql = "SELECT product_categ_name from product_categories";
		List<String> data = _JdbcTemplate.queryForList(sql, String.class);
		return data;
	}catch (Exception e) {
		  System.out.println(e);
		  return null; 
		}
	}
	public String GetProductCategoryNameByProductCateg_ID(String product_categ_id) {
		ProductCategory productCategory = new ProductCategory();
		try {
		String sql = "SELECT * from product_categories where product_categ_id ='"+product_categ_id+"'";
		productCategory = _JdbcTemplate.queryForObject(sql, new MapperProductCategory(productsDao));
		return productCategory.getProduct_categ_name();
		}catch (Exception e) {
			  System.out.println(e);
			  return null; 
			}
	}

	public String getStringProductCategoryIDByName(String product_categ_name) {
		try {
		ProductCategory productCategory = new ProductCategory();
		String sql = "SELECT * FROM product_categories WHERE product_categ_name=" + "'"
				+ product_categ_name + "'";
		productCategory = _JdbcTemplate.queryForObject(sql, new MapperProductCategory(productsDao));
		return productCategory.getProduct_categ_id();
		}catch (Exception e) {
			  System.out.println(e);
			  return null; 
			}

	}

	public int UpdateProductCategoryID(String product_categ_id) {
		try {
			String sql = "UPDATE product_categories SET product_categ_id = ? WHERE product_categ_id = ?";
			Object[] param = {
				product_categ_id,
				product_categ_id
			};
			int update = _JdbcTemplate.update(sql, param);
			return update;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public List<ProductCategory> GetAllDataProductCategory() {
		List<ProductCategory> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM  product_categories ";
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
				if(string.substring(5)==null)
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
				if(string.substring(5)==null)
					x = 0;
				if (x > max)
					max = x;
			}
			max++;
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
		int updatedRow=_JdbcTemplate.update(sql,param);
		return updatedRow;
	}
}
