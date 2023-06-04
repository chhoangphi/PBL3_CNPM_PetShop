package com.petshop.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.entity.User;
import com.petshop.dao.UserDao;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> GetDataUser(String code,String status) {
		// TODO Auto-generated method stub
		return userDao.GetDataUser(code,status);
	}

	@Override
	public int AddUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return userDao.AddUser(user);
	}

	@Override
	public boolean CheckUser(User user) {
		try {
			String pass = user.getPassword();
			User res;
			res = userDao.GetUser(user);

			if (res != null) {
				if (BCrypt.checkpw(pass, res.getPassword())) {
					return true;
				} else
					return false;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public User GetUser(User user) {
		// TODO Auto-generated method stub
		return userDao.GetUser(user);
	}

	@Override
	public User findByUserNameAndPasswordAndStatus(User user) {
		// TODO Auto-generated method stub
		try {
			String pass = user.getPassword();
			User res;
			res = userDao.GetUser(user);

			if (res != null) {
				if (BCrypt.checkpw(pass, res.getPassword())) {
					user.setPassword(res.getPassword());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userDao.findByUserNameAndPasswordAndStatus(user);
	}

	@Override
	public int changePassword(String password, User user) {
		return userDao.changePassword(password, user);
	}

	@Override
	public int changeInfomation(String fullname, String email, String phoneNumber, User user) {
		return userDao.changeInfomation(fullname, email, phoneNumber, user);
	}

	@Override
	public List<User> GetDataUserPaginate(String code,String status,int start, int end) {
		// TODO Auto-generated method stub
		return userDao.GetDataUserPaginate(code,status,start, end);
	}

	@Override
	public int DeleteUser(User user) {
		// TODO Auto-generated method stub
		return userDao.DeleteUser(user);
	}

	@Override
	public int UpdateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.UpdateUser(user);
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUsername(username);
	}

}
