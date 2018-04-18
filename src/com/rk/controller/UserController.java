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
	 * �û���¼����
	 * @return
	 */
	@RequestMapping("/login")
	public String userlogin() {
		return "/user/login";
		
	}
	//��¼����
	@ResponseBody
	@RequestMapping(value="loginin",method=RequestMethod.POST)
	public String loginin(@RequestParam("account")String account,@RequestParam("password")String password,HttpSession session) {
		//ͨ��userServiceֱ�ӵ�¼
		User user = userService.login(account, password);
		//����userService�Ƿ��¼�ɹ�������������(sessionע��ֵ,���ص�¼�ɹ�,�ж��û��Ƿ�����ͨ�û�)
		if(user != null && user.getType() != 0) {
			//����ͨ�û���ɫ
			return AdminLoginData.noAccount("role error");
		}else if(user != null && user.getType() == 0) {
			//��ͨ�û���ɫ
			session.setAttribute("user", user);
			return AdminLoginData.success("login success");
		}
		return AdminLoginData.incorrectPassword("incorrect password");
	}
	
	@ResponseBody
	@RequestMapping(value="/loginoff")
	public String loginoff(HttpSession session) {
		session.removeAttribute("user");
		return AdminLoginData.success("loginoff success");
	}
	
	/**
	 * �����û�ҳ�棬Я������
	 */
     @RequestMapping("/index")
	  public ModelAndView toindex(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/index");
         return mdv;
	}
     /**
 	 * ���ؿ��ó����б�ҳ��
 	 * @return
 	 */
 	@RequestMapping("/field")
 	public ModelAndView toFields(HttpSession session) {
 		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/field");
         return mdv;
 	}
 	
 	
 	 /**
 	 * ���ؿ�����Ʒ�б�ҳ��
 	 * @return
 	 */
 	@RequestMapping("/item")
 	public ModelAndView toItems(HttpSession session) {
 		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/item");
         return mdv;
 	}
 	 /**
 	 * ��������ҳ��,���볡�ػ�����Ʒ
 	 * @return
 	 */
 	@RequestMapping("/apply")
 	public ModelAndView toApply(HttpSession session) {
 		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/apply");
         return mdv;
 	}
 	
 	/**
 	 * ��������ҳ��,���볡�ػ�����Ʒ
 	 * @return
 	 */
 	@RequestMapping("/appling")
 	public ModelAndView toAppling(HttpSession session) {
 		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/appling");
         return mdv;
 	}
 	
 	/**
 	 * ����������ͨ���б�ҳ��
 	 * @return
 	 */
 	@RequestMapping("/applied")
 	public ModelAndView toApplied(HttpSession session) {
 		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/applied");
         return mdv;
 	}
 	
 	/**
 	 * ����������ʷ(���Ѿ��黹��)ҳ��
 	 * @return
 	 */
 	@RequestMapping("/applyhistory")
 	public ModelAndView toApplyhistory(HttpSession session) {
 		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("user");
		mdv.addObject("user", user);
		//2.����view name
		mdv.setViewName("/user/applyhistory");
         return mdv;
 	}
}
