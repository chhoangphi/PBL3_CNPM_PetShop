package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.petshop.entity.Menus;
import com.petshop.entity.User;
import com.petshop.entity.Activity;
import com.petshop.entity.MapperActivity;
import com.petshop.entity.MapperMenu;


@Repository
public class ActivityDao extends BaseDao {
		
		public List<Activity> GetDataActivity(){
			List<Activity> list =new ArrayList<Activity>();
			try {
				String sql="SELECT * FROM activities_history ";
				list=_JdbcTemplate.query(sql,new MapperActivity());
				System.out.println("QUERY: "+sql);
				return list;

	        	}catch (Exception e) {
	    			  System.out.println(e);
	    			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
	    			}
			
		}
		public int AddActivity(Activity activity)
		{
			StringBuffer  sql = new StringBuffer();
			sql.append("INSERT INTO ");
			sql.append("activities_history ");
			sql.append("( ");
			sql.append("    activity_id, ");
			sql.append("    activity, ");
			sql.append("    activity_time ");	
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append("'"+activity.getActivity_id()+"',");
			sql.append("'"+activity.getActivity()+"',");
			sql.append("'"+activity.getActivityTime()+"'");
			sql.append(")");
			int insert = _JdbcTemplate.update(sql.toString());
			System.out.println("sql query:" + sql);
			return insert;
		}
		
}
