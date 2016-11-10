package edu.nju.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.RiskDao;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;
import edu.nju.model.User;

@Repository
public class RiskDaoImpl implements RiskDao {
	@Autowired
	private BaseDao baseDao;

	@Override
	public boolean add(RiskItem risk) {
		try {
			baseDao.save(risk);
			int id=risk.getId();
			RiskState state=new RiskState();
			state.setRid(id);
			state.setCreateTime(new Date());
			state.setDetail("建立风险条目");
			state.setState("新建");
			addState(state);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			baseDao.delete(RiskItem.class, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modify(RiskItem risk) {
		try {
			baseDao.update(risk);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> show() {
		return baseDao.getAllList(RiskItem.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> find(String keyword) {
		String str = "from RiskItem s where s.content like \'%" + keyword
				+ "%\'";
		List<RiskItem> list = baseDao.find(str);
		return list;
	}

	@Override
	public boolean addState(RiskState state) {
		try {
			baseDao.save(state);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskState> getAllState() {
		return baseDao.getAllList(RiskState.class);
	}

	@Override
	public RiskState getStateById(int id) {
		RiskState state = (RiskState) baseDao.load(RiskState.class, id);
		return state;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> getSubmitItem(int userId) {
		String str = "from RiskItem s where s.submitterId=?";
		Session session = baseDao.getNewSession();
		List<RiskItem> result = session.createQuery(str)
				.setParameter(0, userId).list();
		return result;
	};

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskState> getSubmitState(int riskId) {
		String str = "from RiskState s where s.rid=? order by id desc";
		Session session = baseDao.getNewSession();
		List<RiskState> result = session.createQuery(str)
				.setParameter(0, riskId).list();
		return result;
	};

	@SuppressWarnings("unchecked")
	@Override
	public List<RiskItem> getFollowItem(int userId) {
		String str = "from RiskItem s where s.followerId=?";
		Session session = baseDao.getNewSession();
		List<RiskItem> result = session.createQuery(str)
				.setParameter(0, userId).list();
		return result;
	}

	@Override
	public RiskItem getItemById(int id) {
		RiskItem state = (RiskItem) baseDao.load(RiskItem.class, id);
		return state;
	};

}
