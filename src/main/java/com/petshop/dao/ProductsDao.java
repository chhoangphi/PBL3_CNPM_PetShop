package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petshop.entity.*;

@Repository
public class ProductsDao extends BaseDao {

	public StringBuffer SqlProductByTypeID(String type_id,String sort) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" pd.product_name");
		sql.append(",pd.product_id");
		sql.append(", pd.img");
		sql.append(", pd.price");
		sql.append(", pd.description");
		sql.append(", pd.product_categ_id");
		sql.append(" FROM");
		sql.append(" product_categories AS pc");
		sql.append(" INNER JOIN");
		sql.append(" type_of_category AS tc");
		sql.append(" ON");
		sql.append(" pc.type_id=tc.id");
		sql.append(" INNER JOIN");
		sql.append(" products AS pd");
		sql.append(" ON");
		sql.append(" pd.product_categ_id=pc.product_categ_id");
		sql.append(" WHERE tc.id=");
		sql.append("'" + type_id + "'");
		String []s=sort.split("-");
		sql.append(" ORDER BY "+s[0]+" "+s[1]);
		return sql;
	}

	public StringBuffer SqlProductByTypeIDLimit9(String type_id,String sort) {
		StringBuffer sql = SqlProductByTypeID(type_id,sort);
		sql.append(" LIMIT 9");
		return sql;
	}

	public List<Products> GetDataProductPaginate(int start, int end) {
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql = SqlProductPaginate(start, end).toString();
			System.out.println("SQL Query: " + sql);
			listproduct = _JdbcTemplate.query(sql, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public StringBuffer SqlProductPaginate(int start, int totalPage) {
		StringBuffer sql = SqlProduct();
		sql.append(" LIMIT ");
		sql.append(start + ", " + totalPage);
		return sql;
	}

	public StringBuffer SqlProductByTypeIDPaginate(String type_id, int start, int totalPage,String sort) {
		StringBuffer sql = SqlProductByTypeID(type_id,sort);
		sql.append(" LIMIT ");
		sql.append(start + ", " + totalPage);
		return sql;
	}

	public StringBuffer SqlProduct() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" *");
		sql.append(" FROM");
		sql.append(" products");
		return sql;
	}

	public StringBuffer SqlProductByProductID(String product_id) {
		StringBuffer sql = SqlProduct();
		sql.append(" WHERE");
		sql.append(" product_id=");
		sql.append("'" + product_id + "'");
		return sql;
	}

	public StringBuffer SqlProductByProductCategoryID(String product_categ_id) {
		StringBuffer sql = SqlProduct();
		sql.append(" WHERE");
		sql.append(" product_categ_id=");
		sql.append("'" + product_categ_id + "'");
		return sql;
	}

	public StringBuffer SqlProductByCategID(String product_categ_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" pd.product_name");
		sql.append(",pd.product_id");
		sql.append(", pd.img");
		sql.append(", pd.price");
		sql.append(", pd.description");
		sql.append(", pd.product_categ_id");
		sql.append(" FROM");
		sql.append(" product_categories AS pc");
		sql.append(" INNER JOIN");
		sql.append(" type_of_category AS tc");
		sql.append(" ON");
		sql.append(" pc.type_id=tc.id");
		sql.append(" INNER JOIN");
		sql.append(" products AS pd");
		sql.append(" ON");
		sql.append(" pd.product_categ_id=pc.product_categ_id");
		sql.append(" WHERE pd.product_categ_id=");
		sql.append("'" + product_categ_id + "'");
		sql.append(" ORDER BY pd.sold_quantity DESC");
		return sql;
	}

	public List<Products> GetDataProductByTypeIDLimit9(String type_id,String sort) {
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql = SqlProductByTypeIDLimit9(type_id,sort).toString();
			System.out.println("SQL Query: " + sql);
			listproduct = _JdbcTemplate.query(sql, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Products> GetDataProductByTypeID(String type_id,String sort) {
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql = SqlProductByTypeID(type_id,sort).toString();
			System.out.println("SQL Query: " + sql);
			listproduct = _JdbcTemplate.query(sql, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Products> GetDataProductByTypeIDPaginate(String type_id, int start, int end,String sort) {
		List<Products> listproduct = new ArrayList<>();
		try {
			StringBuffer sql = SqlProductByTypeIDPaginate(type_id, start, end,sort);
			listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public StringBuffer SqlProductByCategIDPaginate(String product_categ_id, int start, int totalPage) {
		StringBuffer sql = SqlProductByCategID(product_categ_id);
		sql.append(" LIMIT ");
		sql.append(start + ", " + totalPage);
		return sql;
	}

	public List<Products> GetDataProductByCategIDPaginate(String product_categ_id, int start, int end) {
		List<Products> listproduct = new ArrayList<>();
		try {
			String sql = SqlProductByCategIDPaginate(product_categ_id, start, end).toString();
			listproduct = _JdbcTemplate.query(sql, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Products GetDataProductByProductID(String product_id) {
		Products product = new Products();
		try {
			String sql = SqlProductByProductID(product_id).toString();
			System.out.println("SQL Query:1 " + sql);
			product = _JdbcTemplate.queryForObject(sql, new MapperProducts());
			return product;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Products> GetDataProductByProductCategoryIDPaginate(String product_categ_id, int start,
			int totalProductpage,String sort) {
		List<Products> listproduct = new ArrayList<>();
		String []s=sort.split("-");
		try {
			StringBuffer sql = SqlProductByProductCategoryID(product_categ_id);
			sql.append("ORDER BY "+s[0]+" "+s[1]);
			sql.append(" LIMIT ");
			sql.append(start + ", " + totalProductpage);
			System.out.println("SQL Query: " + sql);

			listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Products> GetDataProductByProductCategoryID(String product_categ_id) {
		List<Products> listproduct = new ArrayList<>();
		try {
			StringBuffer sql = SqlProductByProductCategoryID(product_categ_id);
			listproduct = _JdbcTemplate.query(sql.toString(), new MapperProducts());
			System.out.println("SQL Query: " + sql);

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
			System.out.println("SQL Query: " + sql);
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
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append("products ");
		sql.append("SET ");
//		sql.append("    product_id = ");
//		sql.append("'"+products.getProduct_id()+"',");
		sql.append("    product_name = ");
		sql.append("'" + products.getProduct_name() + "',");
		sql.append("    img =  ");
		sql.append("'" + products.getImg() + "',");
		sql.append("    price =  ");
		sql.append(products.getPrice() + ",");
		sql.append("    description = ");
		sql.append("'" + products.getDescription() + "',");
		sql.append("    product_categ_id = ");
		sql.append("'" + products.getProduct_categ_id() + "'");
		sql.append("  WHERE product_id ='" + products.getProduct_id() + "';");
		System.out.println(sql.toString());

		int insert = _JdbcTemplate.update(sql.toString());
		return insert;
	}

	public int DeleteProduct(Products products) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM ");
		sql.append("products ");
		sql.append("  WHERE product_id ='" + products.getProduct_id() + "';");
		System.out.println(sql.toString());
		int insert = _JdbcTemplate.update(sql.toString());
		return insert;
	}

	public int AddProduct(Products products) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("products ");
		sql.append("( ");
		sql.append("    product_id, ");
		sql.append("    product_name, ");
		sql.append("    img, ");
		sql.append("    price, ");
		sql.append("    product_categ_id, ");
		sql.append("    description");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("'" + products.getProduct_id() + "',");
		sql.append("'" + products.getProduct_name() + "',");
		sql.append("'" + products.getImg() + "',");
		sql.append("" + products.getPrice() + ",");
		sql.append("'" + products.getProduct_categ_id() + "',");
		sql.append("'" + products.getDescription() + "'");
		sql.append(")");
		int insert = _JdbcTemplate.update(sql.toString());
		System.out.println("sql query:" + sql.toString());
		return insert;
	}
	public String getStringProductNameByProductID(String product_id) {
		Products product = new Products();
		try {
			String sql = "SELECT * FROM products WHERE product_id=" + "'" + product_id + "'";
			product = _JdbcTemplate.queryForObject(sql, new MapperProducts());
			System.out.println("SQL Query: " + sql);

			return product.getProduct_name();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public List<String> GetDataProductID() {
		// TODO Auto-generated method stub
		String sql = "SELECT product_id from products";
//		List<String> list =new ArrayList<>();
//		list =_JdbcTemplate.execute(sql, list));
//		//list=_JdbcTemplate.query(sql,new MapperProductCategory());
		List data = _JdbcTemplate.queryForList(sql, String.class);

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
			System.out.println("SQL Query: " + sqlQuery);
			listproduct = _JdbcTemplate.query(sqlQuery, new MapperProducts());
			return listproduct;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
