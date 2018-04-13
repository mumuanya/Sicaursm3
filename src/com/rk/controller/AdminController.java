package com.rk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rk.model.User;
import com.rk.service.AdminService;
import com.rk.util.logindata.AdminLoginData;


@RequestMapping(value="/admin")
@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	/** 
	 * 管理员登录方法
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String tologin() {
		return "/admin/login";
	}
	
	//登录动作
	@ResponseBody
	@RequestMapping(value="/loginin")
	public String loginin(@RequestParam("account") String account,
			@RequestParam("password") String password,HttpSession session) {
		//通过adminService直接登录
		User user = adminService.login(account, password);
		//按照adminService是否登录成功进行其它操作(session注入值,返回登录成功,判断用户是否是管理员)
		if(user != null && user.getType() != 1) {
			//非管理员角色
			return AdminLoginData.noAccount("role error");
			
		}else if(user != null && user.getType() == 1) {
			//管理员角色
			session.setAttribute("admin", user);
			return AdminLoginData.success("login success");
		}
		return AdminLoginData.incorrectPassword("incorrect password");
	}
	
	/**
	 * 返回管理员主页面,页面携带数据
	 * @param session
	 * @return
	 */
	 
	@RequestMapping("/index")
	public ModelAndView toindex(HttpSession session) {
		
		ModelAndView mdv = new ModelAndView();
		//1.增加数据
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.增加view name
		mdv.setViewName("/admin/index");
		return mdv;
	}
	
	/**
	 * 返回管理员场地管理页面
	 * @return
	 */
	@RequestMapping("/field")
	public String tofield() {
		return "/admin/field";
	}
	
	/**
	 * 返回管理员物品管理页面
	 * @return
	 */
	@RequestMapping("/item")
	public String toitem() {
		return "/admin/item";
	}
	
	/**
	 * 返回申请查看页面
	 * @return
	 */
	@RequestMapping("/apply")
	public String toapply() {
		return "/admin/apply";
	}
	/**
	 * 返回已经审核通过的申请页面
	 * @return
	 */
	@RequestMapping("/passedapply")
	public String topassedapply() {
		return "/admin/passedapply";
	}
	
	/**
	 * 返回正在归还申请页面
	 * @return
	 */
	@RequestMapping("/returingapply ")
	public String toriapply() {
		return "/admin/returingapply";
	}
	/**
	 * 返回用户申请记录页面
	 * @return
	 */
	@RequestMapping("/applyrecord")
	public String toapplyrecord() {
		return "/admin/applyrecord";
	}

	
	
	
}
