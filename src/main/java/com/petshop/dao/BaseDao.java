package com.petshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {
		@Autowired
		public JdbcTemplate _JdbcTemplate;
}
