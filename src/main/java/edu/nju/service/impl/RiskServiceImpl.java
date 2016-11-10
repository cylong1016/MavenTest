package edu.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.RiskDao;
import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;
import edu.nju.service.RiskService;

@Service 
public class RiskServiceImpl implements RiskService{
	
	@Autowired
	private RiskDao riskDao;

	@Override
	public boolean add(RiskItem risk) {
		return riskDao.add(risk);
	}

	@Override
	public boolean delete(int id) {
		return riskDao.delete(id);
	}

	@Override
	public boolean modify(RiskItem risk) {
		return riskDao.modify(risk);
	}

	@Override
	public List<RiskItem> show() {
		return riskDao.show();
	}

	@Override
	public List<RiskItem> find(String keyword) {
		return riskDao.find(keyword);
	}


	@Override
	public List<RiskState> getAllState() {
		return riskDao.getAllState();
	}

	@Override
	public RiskState getStateById(int id) {
		return riskDao.getStateById(id);
	}
	
	@Override
	public List<RiskItem>  getSubmitItem(int userId){
		return riskDao.getSubmitItem(userId);
	};

	@Override
	public List<RiskState> getState(int riskId){
		return riskDao.getSubmitState(riskId);
	};
	
		@Override
	public List<RiskItem>  getFollowItem(int userId){
		return riskDao.getFollowItem(userId);
	};
	
	
		@Override
	public boolean addState(RiskState state){
		return riskDao.addState(state);
	}

		@Override
		public RiskItem getItemById(int id) {
			return riskDao.getItemById(id);
		};
}
