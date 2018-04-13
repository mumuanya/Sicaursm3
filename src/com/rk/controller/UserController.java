package com.rk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rk.model.User;
import com.rk.service.UserService;
import com.rk.util.logindata.AdminLoginData;


@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * 用户登录方法
	 * @return
	 */
	@RequestMapping("/login")
	public String userlogin() {
		return "/user/login";
		
	}
	//登录动作
	@ResponseBody
	@RequestMapping(value="loginin",method=RequestMethod.POST)
	public String loginin(@RequestParam("account")String account,@RequestParam("password")String password,HttpSession session) {
		//通过userService直接登录
				User user = userService.login(account, password);
				//按照userService是否登录成功进行其它操作(session注入值,返回登录成功,判断用户是否是普通用户)
				if(user != null && user.getType() != 0) {
					//非普通用户角色
					return AdminLoginData.noAccount("role error");
					
				}else if(user != null && user.getType() == 0) {
					//普通用户角色
					session.setAttribute("user", user);
					return AdminLoginData.success("login success");
				}
				return AdminLoginData.incorrectPassword("incorrect password");

}
	
	/**
	 * 返回用户页面，携带数据
	 */
     @RequestMapping("/index")
	  public ModelAndView toindex(HttpSession session) {
	
		ModelAndView mdv = new ModelAndView();
		//1.增加数据
				User user  = (User)session.getAttribute("user");
				
				mdv.addObject("user", user);
				//2.增加view name
				mdv.setViewName("/user/index");
		         return mdv;
	}
     
     /**
 	 * 返回可用场地列表页面
 	 * @return
 	 */
 	@RequestMapping("/fields")
 	public String toFields() {
 		
 		return "/user/fields";
 		
 	}
 	
 	
 	 /**
 	 * 返回可用物品列表页面
 	 * @return
 	 */
 	@RequestMapping("/fields")
 	public String toitems() {
 		
 		return "/user/items";
 		
 	}
 	 /**
 	 * 返回申请页面,申请场地或者物品
 	 * @return
 	 */
 	@RequestMapping("/apply")
 	public String toApply() {
 		
 		return "/user/apply";
 		
 	}
 	/**
 	 * 返回申请已通过列表页面
 	 * @return
 	 */
 	@RequestMapping("/applied")
 	public String toApplied() {
 		
 		return "/user/applied";
 	}
 	
 	/**
 	 * 返回申请历史(即已经归还的)页面
 	 * @return
 	 */
 	@RequestMapping("/applyhistory")
 	public String toApplyHistory() {
 		
 		return "/user/applhistory";
 		
 	}
 	
 	
 	
	 

}
