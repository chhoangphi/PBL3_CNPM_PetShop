package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.petshop.entity.*;

@Repository
public class ProductsDao extends BaseDao {

	public List<Products> GetDataProductByTypeIDLimit8(String type_id,String sort) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT pd.* ");
			sql.append("FROM product_categories AS pc ");
			sql.append("INNER JOIN type_of_category AS tc ON pc.type_id = tc.id ");
			sql.append("INNER JOIN products AS pd ON pd.product_categ_id = pc.product_categ_id ");
			sql.append("WHERE status = 1 AND tc.id = ? ");
			
			String[] s = sort.split("-");
			sql.append("ORDER BY " + s[0] + " " + s[1] + " LIMIT 8");
			
			Object[] param = { type_id };
			List<Products> listproduct = _JdbcTemplate.query(sql.toString(), param, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<Products> GetDataProductPaginate(int start, int end) {
	    List<Products> listproduct = new ArrayList<>();
	    try {
	        StringBuffer sql = new StringBuffer();
	        sql.append("SELECT * FROM products");
	        sql.append(" LIMIT ");
	        sql.append(start).append(", ").append(end);

	        listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts());
	        return listproduct;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}
	public List<Products> GetDataProductByTypeID(String type_id,String sort) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT pd.* ");
			sql.append("FROM product_categories AS pc ");
			sql.append("INNER JOIN type_of_category AS tc ON pc.type_id = tc.id ");
			sql.append("INNER JOIN products AS pd ON pd.product_categ_id = pc.product_categ_id ");
			sql.append("WHERE status = 1 AND tc.id = ? ");
			
			String[] s = sort.split("-");
			sql.append("ORDER BY " + s[0] + " " + s[1]);
			
			Object[] param = { type_id };
			List<Products> listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts(), param);
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Products> GetDataProductByTypeIDPaginate(String type_id, int start, int end,String sort) {
		List<Products> listproduct = new ArrayList<>();
	    try {
	        StringBuffer sql = new StringBuffer();
	        sql.append("SELECT pd.* FROM product_categories AS pc ");
	        sql.append("INNER JOIN type_of_category AS tc ON pc.type_id = tc.id ");
	        sql.append("INNER JOIN products AS pd ON pd.product_categ_id = pc.product_categ_id ");
	        sql.append("WHERE status = 1 AND tc.id = '").append(type_id).append("' ");
	        String[] s = sort.split("-");
	        sql.append("ORDER BY ").append(s[0]).append(" ").append(s[1]).append(" ");
	        sql.append("LIMIT ").append(start).append(", ").append(end);

	        listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts());
	        return listproduct;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	public List<Products> GetDataProductByCategIDPaginate(String product_categ_id, int start, int end) {
		try {
	        String sql = "SELECT pd.* " +
	                     "FROM product_categories AS pc " +
	                     "INNER JOIN type_of_category AS tc ON pc.type_id = tc.id " +
	                     "INNER JOIN products AS pd ON pd.product_categ_id = pc.product_categ_id " +
	                     "WHERE pd.product_categ_id = ? " +
	                     "ORDER BY pd.sold_quantity DESC " +
	                     "LIMIT ?, ?";

	        Object[] param = {
	                product_categ_id,
	                start,
	                end
	        };

	        List<Products> listproduct = _JdbcTemplate.query(sql, param, new MapperProducts());
	        return listproduct;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	public Products GetDataProductByProductID(String product_id) {
		 try {
		        String sql = "SELECT * FROM products WHERE product_id = ?";
		        Object[] param = {product_id};

		        Products product = _JdbcTemplate.queryForObject(sql, param, new MapperProducts());
		        return product;
		    } catch (Exception e) {
		        System.out.println(e);
		        return null;
		    }
	}

	public List<Products> GetDataProductByProductCategoryIDPaginate(String product_categ_id, int start,
			int totalProductpage,String sort) {
		List<Products> listproduct = new ArrayList<>();
	    String[] s = sort.split("-");
	    try {
	        String sql = "SELECT * FROM products WHERE product_categ_id = ? ORDER BY " + s[0] + " " + s[1] + " LIMIT ?, ?";
	        Object[] param = {product_categ_id, start, totalProductpage};

	        listproduct = _JdbcTemplate.query(sql, param, new MapperProducts());
	        return listproduct;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	public List<Products> GetDataProductByProductCategoryID(String product_categ_id) {
		 List<Products> listproduct = new ArrayList<>();
		    try {
		        String sql = "SELECT * FROM products WHERE product_categ_id = ?";
		        Object[] param = {product_categ_id};

		        listproduct = _JdbcTemplate.query(sql, param, new MapperProducts());
		        return listproduct;
		    } catch (Exception e) {
		        System.out.println(e);
		        return null;
		    }
	}

	public String getStringProductCategory(String product_id) {
		Products product = new Products();
		try {
			String sql = "SELECT * FROM products WHERE product_id=" + "'" + product_id + "'";
			product = _JdbcTemplate.queryForObject(sql, new MapperProducts());
			return product.getProduct_categ_id();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Products> GetDataProduct() {
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql = "SELECT * FROM products";
			listproduct = _JdbcTemplate.query(sql, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public int UpdateProduct(Products products) {
		String sql = "UPDATE products SET product_name=?, img =?, price =?, description=?,product_categ_id =?,status=?"
				+ " WHERE product_id =?";
		Object []params= {
				products.getProduct_name()
				,products.getImg()
				,products.getPrice()
				,products.getDescription()
				,products.getProduct_categ_id()
				,products.getStatus()
				,products.getProduct_id()
		};
		int insert = _JdbcTemplate.update(sql,params);
		return insert;
	}

	public int DeleteProduct(Products products) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE  ");
		sql.append("products SET status = 0");
		sql.append("  WHERE product_id ='" + products.getProduct_id() + "';");
		int insert = _JdbcTemplate.update(sql.toString());
		return insert;
	}

	public int AddProduct(Products products) {
		try {
			String sql = "INSERT INTO products (product_id, product_name, status, img, price, product_categ_id, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
			Object[] param = {
				products.getProduct_id(),
				products.getProduct_name(),
				products.getStatus(),
				products.getImg(),
				products.getPrice(),
				products.getProduct_categ_id(),
				products.getDescription()
			};
			int insert = _JdbcTemplate.update(sql, param);
			return insert;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}

	}
	public String getStringProductNameByProductID(String product_id) {
		Products product = new Products();
		try {
			String sql = "SELECT * FROM products WHERE product_id=" + "'" + product_id + "'";
			product = _JdbcTemplate.queryForObject(sql, new MapperProducts());
			return product.getProduct_name();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<String> GetDataProductID(String product_categ_id) {
		String sql = "SELECT product_id from products WHERE product_categ_id LIKE '"+product_categ_id+"%'";
		List<String> data = _JdbcTemplate.queryForList(sql, String.class);

		return data;
	}
	public List<Products> SearchProducts(String productName)
	{
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql = "SELECT * FROM products where product_name like '%"+productName+"%'";
			listproduct = _JdbcTemplate.query(sql, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<Products> GetDataProductPaginateInSearchFeature(int start, int end, String productName) {
		List<Products> listproduct = new ArrayList<>();
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM products");
			sql.append("  WHERE product_name LIKE '%"+productName+ "%'");
			sql.append(" LIMIT " + start + "," + end);
			String sqlQuery =sql.toString();
			listproduct = _JdbcTemplate.query(sqlQuery, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<Products> GetDataProductLimit12(String item_id) {
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql="SELECT * FROM products WHERE products.product_id LIKE ? AND status=1 ORDER BY products.sold_quantity DESC LIMIT 0,8 ";
			Object param=null;
			if (item_id.equals("item01")) param="d%";
			else param="c%";
			listproduct = _JdbcTemplate.query(sql, new MapperProducts(),param);
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<Products> GetDataProductFilterByPrice(String item_id,long min,long max) {
		List<Products> listproduct = new ArrayList<>();
		try {
			StringBuffer sql=new StringBuffer();
			String name,Min,Max;
			Object[] params = null;
			if (item_id.equals("item01")) name="d%";
			else name="c%";
			
			sql.append("SELECT * FROM products WHERE products.product_id LIKE ? AND ");
			if (min!=333 && max!=-333) 
				{
				   sql.append(" products.price >= ? AND  products.price <=? ");
				   Min=String.valueOf(min);
				   Max=String.valueOf(max);
				   params = new Object[]{name, Min, Max};
				}
			else
			{
			if (min!=-333) {
				sql.append(" products.price >= ? ");
				Min=String.valueOf(min);
				 params = new Object[]{name, Min};
			}
			if (max!=-333) {
				sql.append(" products.price >= ? ");
				Max=String.valueOf(max);
				 params = new Object[]{name, Max};
			}
			}
			sql.append(" ORDER BY products.price ASC ");
			listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts(),params);
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<Products> findProductByProductCategory(String product_categ_id,String status){
		List<Products> listproduct = new ArrayList<>();
		try {
			StringBuffer sql=new StringBuffer("SELECT * FROM products  WHERE product_categ_id =?");
			Object []param=null;
			if (status.equals("all")) param=new Object[] {product_categ_id};
			if (status.equals("active")) {
				sql.append(" AND status=?");
				param=new Object[] {product_categ_id,1};
			}
			if (status.equals("inactive")) {
				sql.append(" AND status=?");
				param=new Object[] {product_categ_id,0};
			}
			listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts(),param);
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<Products> findProductByProductCategoryIDPaginate(String product_categ_id,String status,int start, int totalPage,String sort){
		List<Products> listproduct = new ArrayList<>();
		try {
			StringBuffer sql=new StringBuffer("SELECT * FROM products  WHERE product_categ_id =?");
			String []s=sort.split("-");
			
			Object []param=null;
			if (status.equals("all")) {
				sql.append(" ORDER BY ? ?");
				sql.append(" LIMIT ? ,?");
				param=new Object[] {product_categ_id,s[0],s[1],start,totalPage};
			}
			if (status.equals("active")) {
				sql.append(" AND status=?");
				sql.append(" ORDER BY ? ?");
				sql.append(" LIMIT ? ,?");
				param=new Object[] {product_categ_id,1,s[0],s[1],start,totalPage};
			}
			if (status.equals("inactive")) {
				sql.append(" AND status=?");
				sql.append(" ORDER BY ? ?");
				sql.append(" LIMIT ? ,?");
				param=new Object[] {product_categ_id,0,s[0],s[1],start,totalPage};
			}
			listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts(),param);
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
