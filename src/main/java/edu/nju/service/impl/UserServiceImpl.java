package edu.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.UserDao;
import edu.nju.model.User;
import edu.nju.service.UserService;

@Service 
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User register(String username, String password, String role) {
		return userDao.register(username,password,role);
	}

	@Override
	public User login(String username, String password, String role) {
		return userDao.login(username,password,role);
	}

	@Override
	public List<User> showAll() {
		return userDao.showAll();
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public boolean modifyUser(User user) {
		return userDao.modifyUser(user);
	}

	@Override
	public List<User> getUser(String keyword) {
		return userDao.getUser(keyword);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

}
