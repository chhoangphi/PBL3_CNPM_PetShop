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
				return list;

	        	}catch (Exception e) {
	    			  System.out.println(e);
	    			  return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
	    			}
			
		}
		public int AddActivity(Activity activity)
		{
			try {
				String sql = "INSERT INTO activities_history (activity_id, activity, activity_time, modifiedBy) VALUES (?, ?, ?, ?)";
				
				Object[] param = {
					activity.getActivity_id(),
					activity.getActivity(),
					activity.getActivityTime(),
					activity.getModifiedBy()
				};
				
				int insert = _JdbcTemplate.update(sql, param);
				return insert;
			} catch (Exception e) {
				System.out.println(e);
				return 0; // or return an empty list depending on the requirement
			}
		}
		
}
