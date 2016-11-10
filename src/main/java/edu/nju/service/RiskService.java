package edu.nju.service;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;

/**
 * @author lsy
 */
public interface RiskService {
	//风险条目增删改查
	public boolean add(RiskItem risk);	//风险条目输入
	public boolean delete(int id);
	public boolean modify(RiskItem risk);
	public List<RiskItem> show();
	public List<RiskItem> find(String keyword);
	public RiskItem getItemById(int id);
	
	//风险状态增、查
	public boolean addState(RiskState state);//跟踪者更新自己跟踪的某条风险条目的状态
	public List<RiskState> getAllState();
	public RiskState getStateById(int id);
	
	//对需求再次理解后的新增方法
	public List<RiskItem>  getSubmitItem(int userId);//提交者查看自己提交的全部风险条目
	public List<RiskState> getState(int riskId);//提交者查看自己提交的某条风险条目状态
	public List<RiskItem>  getFollowItem(int userId);//跟踪者查看自己跟踪的全部风险条目
}
