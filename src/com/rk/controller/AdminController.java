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
	 * ����Ա��¼����
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String tologin() {
		return "/admin/login";
	}
	
	//��¼����
	@ResponseBody
	@RequestMapping(value="/loginin")
	public String loginin(@RequestParam("account") String account,
			@RequestParam("password") String password,HttpSession session) {
		//ͨ��adminServiceֱ�ӵ�¼
		User user = adminService.login(account, password);
		//����adminService�Ƿ��¼�ɹ�������������(sessionע��ֵ,���ص�¼�ɹ�,�ж��û��Ƿ��ǹ���Ա)
		if(user != null && user.getType() != 1) {
			//�ǹ���Ա��ɫ
			return AdminLoginData.noAccount("role error");
			
		}else if(user != null && user.getType() == 1) {
			//����Ա��ɫ
			session.setAttribute("admin", user);
			return AdminLoginData.success("login success");
		}
		return AdminLoginData.incorrectPassword("incorrect password");
	}
	@ResponseBody
	@RequestMapping(value="/loginoff")
	public String loginoff(HttpSession session) {
		session.removeAttribute("admin");
		return AdminLoginData.success("loginoff success");
	}
	
	/**
	 * ���ع���Ա��ҳ��,ҳ��Я������
	 * @param session
	 * @return
	 */
	 
	@RequestMapping("/index")
	public ModelAndView toindex(HttpSession session) {
		
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/index");
		return mdv;
	}
	
	/**
	 * ���ع���Ա���ع���ҳ��
	 * @return
	 */
	@RequestMapping("/field")
	public ModelAndView tofield(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/field");
		return mdv;
	}
	
	/**
	 * ���ع���Ա��Ʒ����ҳ��
	 * @return
	 */
	@RequestMapping("/item")
	public ModelAndView toitem(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/item");
		return mdv;
	}
	
	/**
	 * ��������鿴ҳ��
	 * @return
	 */
	@RequestMapping("/apply")
	public ModelAndView toapply(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/apply");
		return mdv;
	}
	/**
	 * �����Ѿ����ͨ��������ҳ��
	 * @return
	 */
	@RequestMapping("/passedapply")
	public ModelAndView topassedapply(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/passedapply");
		return mdv;
	}
	
	/**
	 * �������ڹ黹����ҳ��
	 * @return
	 */
	@RequestMapping("/returingapply")
	public ModelAndView toriapply(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/returingapply");
		return mdv;
	}
	/**
	 * �����û������¼ҳ��
	 * @return
	 */
	@RequestMapping("/applyrecord")
	public ModelAndView toapplyrecord(HttpSession session) {
		ModelAndView mdv = new ModelAndView();
		//1.��������
		User user  = (User)session.getAttribute("admin");
		
		mdv.addObject("admin", user);
		//2.����view name
		mdv.setViewName("/admin/applyrecord");
		return mdv;
	}

	
	
	
}
