package edu.nju.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.model.User;
import edu.nju.service.RiskService;
import edu.nju.service.UserService;

@SuppressWarnings("serial")
@Controller
public class UserAction extends BaseAction{
	
	@Autowired
	UserService userService;
	@Autowired
	RiskService riskService;
	
	@SuppressWarnings("unchecked")
	public String login(){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		User user=userService.login(username, password, role);
		if(user==null){
			return "error";
		}else{
			List<User> uList=userService.showAll();
			request.setAttribute("uList", uList);
			session.put("user", user);
			return "success";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String register(){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		User user=userService.register(username, password, role);
		if(user==null){
			return "error";
		}else{
			List<User> uList=userService.showAll();
			request.setAttribute("uList", uList);
			session.put("user", user);
			return "success";
		}
	}
}
