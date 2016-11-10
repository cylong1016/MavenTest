package edu.nju.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;
import edu.nju.model.User;
import edu.nju.service.RiskService;
import edu.nju.service.UserService;

@SuppressWarnings("serial")
@Controller
public class RiskAction extends BaseAction{
	@Autowired
	RiskService riskService;
	@Autowired
	UserService userService;
	
	public String add(){
		String name=request.getParameter("rname");
		String content=request.getParameter("rcontent");
		String possibility=request.getParameter("rpossible");
		String influence=request.getParameter("rinfluence");
		String trig=request.getParameter("rtrig");
		String follower=request.getParameter("folSelect");
		User user=(User) session.get("user");
		RiskItem r=new RiskItem();
		r.setName(name);
		r.setContent(content);
		r.setPossibility(possibility);
		r.setLevel(influence);
		r.setRiskTrigger(trig);
		r.setSubmitterId(user.getId());
		r.setSubName(user.getUsername());
		r.setFollowerId(Integer.parseInt(follower));
		User userf=userService.getById(Integer.parseInt(follower));
		r.setFolName(userf.getUsername());
		boolean result=riskService.add(r);
		if(result==true){
			List<RiskItem> rlist=riskService.getSubmitItem(user.getId());
			request.setAttribute("rList", rlist);
			request.setAttribute("type", 0);
			return "success";
		}else{
			return "error";
		}
	}
	
	public String toRisk(){
		List<User> uList=userService.showAll();
		request.setAttribute("uList", uList);
		return "success";
	}
	
	public String toState(){
		List<User> uList=userService.showAll();
		request.setAttribute("uList", uList);
		User u=(User) session.get("user");
		List<RiskItem> rList=riskService.getFollowItem(u.getId());
		request.setAttribute("rList", rList);
		request.setAttribute("type",1);
		return "success";
	}
	
	public String showState(){
		String id=request.getParameter("hiddenCourseId");
		RiskItem item=riskService.getItemById(Integer.parseInt(id));
		request.setAttribute("itemName", item.getName());
		request.setAttribute("itemId", item.getId());
		List<RiskState> slist=riskService.getState(Integer.parseInt(id));
		request.setAttribute("slist", slist);
		return "success";
	}
	
	public String addState(){
		String rdescription=request.getParameter("rdescription");
		String rdetail=request.getParameter("rdetail");
		String rid=request.getParameter("rid");
		RiskState s=new RiskState();
		s.setCreateTime(new Date());
		s.setDetail(rdetail);
		s.setState(rdescription);
		s.setRid(Integer.parseInt(rid));
		riskService.addState(s);
		List<RiskState> slist=riskService.getState(Integer.parseInt(rid));
		request.setAttribute("slist", slist);
		return "success";
	}
	
	public String riskType(){
		String type=request.getParameter("riskSelect");
		User user=(User) session.get("user");
		if(type.equals("0")){
			List<RiskItem> rlist=riskService.getSubmitItem(user.getId());
			request.setAttribute("rList", rlist);
			request.setAttribute("type", 0);
		}else{
			List<RiskItem> rlist=riskService.getFollowItem(user.getId());
			request.setAttribute("rList", rlist);
			request.setAttribute("type", 1);
		}
		return "success";
	}
	
}
