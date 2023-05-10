package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.petshop.entity.*;

@Repository
public class UserDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<User> GetDataUser(){
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		list = _jdbcTemplate.query(sql, new MapperUser());
		return list;
	}
	public int AddUser(User user)
	{
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("user ");
		sql.append("( ");
		sql.append("    username, ");
		sql.append("    password, ");
		sql.append("    fullName, ");
		sql.append("    phonenumber, ");
		sql.append("    gender, ");
		sql.append("    dateofbirth, ");
		sql.append("    roleid, ");
		sql.append("    status, ");
		sql.append("    email ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("'"+user.getUsername()+"',");
		sql.append("'"+user.getPassword()+"',");
		sql.append("'"+user.getFullName()+"',");
		sql.append("'"+user.getPhoneNumber()+"',");
		sql.append("'"+user.getGender()+"',");
		sql.append("'"+user.getDateOfBirth()+"',");
		sql.append("'"+user.getRoleId()+"',");
		sql.append("'"+user.getStatus()+"',");
		sql.append("'"+user.getEmail()+"'");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		System.out.println("sql query:" + sql);
		return insert;
	}
	public User GetUser(User user)
	{
		try {
			String  sql = "SELECT * FROM user WHERE username= '"+user.getUsername()+"'";
			User res = _jdbcTemplate.queryForObject(sql,new MapperUser());
			return res;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public User findByUserNameAndPasswordAndStatus(User user) {
		
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.roleid = u.roleid");
		sql.append(" WHERE username = ");
		sql.append("'"+user.getUsername()+"'");
		sql.append(" AND password =");
		sql.append("'"+user.getPassword()+"'");
		sql.append(" AND status =");
		sql.append("'"+user.getStatus()+"'");
		List<User> users = _jdbcTemplate.query(sql.toString(), new MapperUser());
		return users.isEmpty() ? null : users.get(0);
	}
	public int changePassword(String password,User user) {
		try {
			password=BCrypt.hashpw(password, BCrypt.gensalt(12));
			String sql="UPDATE user SET password=? WHERE username=?";
			
			Object []params= {
				password
			   ,user.getUsername()
			};
			int rowUpdate=_jdbcTemplate.update(sql,params);
			return rowUpdate;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
