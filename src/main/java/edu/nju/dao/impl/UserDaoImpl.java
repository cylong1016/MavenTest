package edu.nju.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.UserDao;
import edu.nju.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public User register(String username, String password, String role) {
		try{
			User u=new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setRole(role);
			baseDao.save(u);
			System.out.println(u.getId());
			return u;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(String username, String password, String role) {
		String str = "from User s where s.username=? and s.password=?";
		Session session = baseDao.getNewSession();
		List<User> result = session.createQuery(str).setParameter(0, username).setParameter(1, password).list();
		if (result.size() != 0) {
			return result.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> showAll() {
		return baseDao.getAllList(User.class);
	}

	@Override
	public boolean deleteUser(int id) {
		try{
			baseDao.delete(User.class,id);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modifyUser(User user) {
		try{
			baseDao.update(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser(String keyword) {
		String str = "from User s where s.username like \'%" + keyword + "%\'";
		List<User> list = baseDao.find(str);
		return list;
	}

	@Override
	public User getById(int id) {
		User user=(User)baseDao.load(User.class, id);
		return user;
	}

}
