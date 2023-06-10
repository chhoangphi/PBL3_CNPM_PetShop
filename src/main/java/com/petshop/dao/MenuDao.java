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
				return list;

	        	}catch (Exception e) {
	    			  System.out.println(e);
	    			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
	    			}
			
		}
		public String GetMaxMenuID()
		{
			
			try {
				String sql = "SELECT menu_id FROM menus";
				List<String> data = _JdbcTemplate.queryForList(sql, String.class);
				int x = 0;
				
				int max = 0;
				System.out.println("sizemenu = " + data.size());
				// String tmp1 = id.substring(0, 4);
				for (String string : data) {
					if(string.contains("static")==false) {
					x = Integer.parseInt(string.substring(4));
					System.out.println("x = " + x);
					if(string.substring(4)==null)
						x = 0;
					if (x > max)
						max = x;
					}
					else continue;
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
		public int AddMenu(Menus menu)
		{
			String sql="  INSERT INTO menus VALUES(?,?,?,?)";
			System.out.println("menuid = "+ menu.getMenu_id());
			System.out.println("order = "+ menu.getMenu_id().substring(5,6));
			Object[] param= {
					menu.getMenu_id(),
					menu.getMenu_name(),
					Integer.parseInt(menu.getMenu_id().substring(5,6))+1,
					menu.getItem_id()
			};
			System.out.println(sql);
			int updatedRow=_JdbcTemplate.update(sql,param);
			return updatedRow;
		}
		
}
