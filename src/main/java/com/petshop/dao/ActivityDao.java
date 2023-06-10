package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.petshop.entity.Activity;
import com.petshop.entity.MapperActivity;

@Repository
public class ActivityDao extends BaseDao {

	public List<Activity> GetDataActivity() {
		List<Activity> list = new ArrayList<Activity>();
		try {
			String sql = "SELECT * FROM activities_history ";
			list = _JdbcTemplate.query(sql, new MapperActivity());
			return list;

		} catch (Exception e) {
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

	public List<String> FindDataOrderInMonthAndYear() {

		try {
			String sql = "SELECT  DISTINCT(MONTH(activity_time)) AS monthOfActivity FROM activities_history WHERE  YEAR(activity_time)=2023\n"
					+ "\n" + "GROUP BY MONTH(activity_time)\n" + "ORDER BY MONTH(activity_time)";
			System.out.println(sql);
			List<String> list = _JdbcTemplate.queryForList(sql, String.class);
			System.out.println(list.size());
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public List<Activity> GetDataActivityByMonthAndYear(String month, String year) {
		List<Activity> list = new ArrayList<Activity>();
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM activities_history WHERE ");
			sql.append( " YEAR(activity_time)=" + year);
			
			if(!month.equals("null"))
					sql.append(" AND MONTH(activity_time) = " + month);
			
			
			list = _JdbcTemplate.query(sql.toString(), new MapperActivity());
			System.out.println(sql.toString());
			return list;

		} catch (Exception e) {
			System.out.println(e);
			return null; // hoặc trả về danh sách rỗng tùy thuộc vào yêu cầu
		}

	}

	public List<Activity> GetDataActivityPaginate(int start, int end, String month, String year) {
		List<Activity> listOrder = new ArrayList<>();
		try {
			String sql = SqlOrderPaginate(start, end, month, year).toString();
			listOrder = _JdbcTemplate.query(sql, new MapperActivity());
			System.out.println(sql);
			return listOrder;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public StringBuffer SqlOrderPaginate(int start, int totalPage, String month, String year) {
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM activities_history");
		sql.append(" WHERE YEAR(activity_time)='" + year + "'");
		if (!month.equals("null")) {
			sql.append(" AND MONTH(activity_time)='" + month + "'");
		}
		sql.append(" LIMIT ");
		sql.append(start + ", " + totalPage);
		
		return sql;
	}
}
