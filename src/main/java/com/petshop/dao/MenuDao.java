package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petshop.entity.Menus;
import com.petshop.entity.MapperMenu;


@Repository
public class MenuDao extends BaseDao {
		
		public List<Menus> GetDataMenu(){
			List<Menus> list =new ArrayList<Menus>();
			try {
				String sql="SELECT * FROM menus";
				list=_JdbcTemplate.query(sql,new MapperMenu());
				System.out.println("QUERY: "+sql);
				return list;

	        	}catch (Exception e) {
	    			  System.out.println(e);
	    			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
	    			}
			
		}
		
}
