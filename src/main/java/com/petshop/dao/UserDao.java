package com.petshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.petshop.entity.*;

@Repository
public class UserDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<User> GetDataUser(String code,String status){
		List<User> list = new ArrayList<User>();
		StringBuffer sql=new StringBuffer("SELECT * FROM user as u INNER JOIN role AS r ON r.roleid = u.roleid WHERE code=?");
		Object []params=null;
		if (status.equals("all")) {
			params=new Object[] {
					code
			};
		}
		if (status.equals("active")) {
			sql.append(" AND status=?");
			params=new Object[] {
					code,1
			};
		}
		if (status.equals("inactive")) {
			sql.append(" AND status=?");
			params=new Object[] {
					code,0
			};
		}
		list = _jdbcTemplate.query(sql.toString(), new MapperUser(),params);
		return list;
	}
	public int AddUser(User user)
	{
		 try {
		        String sql = "INSERT INTO user (username, password, fullName, phonenumber, gender, dateofbirth, roleid, status, email) " +
		                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        Object[] param = {
		                user.getUsername(),
		                user.getPassword(),
		                user.getFullName(),
		                user.getPhoneNumber(),
		                user.getGender(),
		                user.getDateOfBirth(),
		                user.getRoleId(),
		                user.getStatus(),
		                user.getEmail()
		        };

		        int insert = _jdbcTemplate.update(sql, param);
		        return insert;
		    } catch (Exception e) {
		        System.out.println(e);
		        return 0;
		    }
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
	public int changeInfomation(String fullname,String email,String phoneNumber,User user) {
		try {
			String sql="UPDATE user SET fullname=?,email=?,phoneNumber=? WHERE username=?";
			Object []params= {
				fullname,
				email,
				phoneNumber
			   ,user.getUsername()
			};
			int rowUpdate=_jdbcTemplate.update(sql,params);
			return rowUpdate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public List<User> GetDataUserPaginate(String code,String status,int start, int end) {
		List<User> listUser = new ArrayList<>();
		try {
			StringBuffer sql=new StringBuffer("SELECT * FROM user as u INNER JOIN role AS r ON r.roleid = u.roleid WHERE code=?");
			Object []params=null;
			if (status.equals("all")) {
				sql.append(" LIMIT ?, ?");
				params=new Object[] {
						code,start,end
				};
			}
			if (status.equals("active")) {
				sql.append(" AND status=?");
				sql.append(" LIMIT ?, ?");
				params=new Object[] {
						code,1,start,end
				};
			}
			if (status.equals("inactive")) {
				sql.append(" AND status=?");
				sql.append(" LIMIT ?, ?");
				params=new Object[] {
						code,0,start,end
				};
			}
			listUser = _jdbcTemplate.query(sql.toString(), new MapperUser(),params);
			return listUser;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public StringBuffer SqlUserPaginate(int start, int totalPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM user ");
		sql.append(" LIMIT ");
		sql.append(start + ", " + totalPage);
		return sql;
	}
	public int DeleteUser(User user)
	{
		try {
			String sql = "UPDATE USER SET status = 0 WHERE username='"+user.getUsername()+"'";
			int rowUpdate=_jdbcTemplate.update(sql);
			return rowUpdate;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
 	}
	public int UpdateUser(User user) {
		try {			
			String sql = "UPDATE user SET fullname=?, status=? , phonenumber=?, email=? WHERE username=?";
			Object []params= {
				    user.getFullName(),
				    user.getStatus(),
					user.getPhoneNumber(),
				    user.getEmail(),
				    user.getUsername()
				    
				};
			int rowUpdate=_jdbcTemplate.update(sql,params);
			return rowUpdate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public User findUserByUsername(String username) {
		User user = new User();
		try {
			String sql="SELECT * FROM user WHERE username=?";
			Object param= username;
			user=(User) _jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class), param);
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}
