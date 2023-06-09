package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperActivity implements RowMapper<Activity> {

	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {

		Activity activity = new Activity();
		activity.setActivity_id(rs.getString("activity_id"));
		activity.setActivity(rs.getString("activity"));
		activity.setActivityTime(rs.getTimestamp("activity_time").toLocalDateTime());
		activity.setModifiedBy(rs.getString("modifiedBy"));
		return activity;
	}
}
