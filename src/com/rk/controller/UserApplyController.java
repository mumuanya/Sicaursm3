package com.rk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rk.model.Apply;
import com.rk.model.User;
import com.rk.service.ApplyService;
import com.rk.util.JsonResult;

@RequestMapping(value= "/user/apply")
@Controller
public class UserApplyController {
	
	@Autowired
	ApplyService applyservice;
	
	
	/**
	 * �ύ����
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/submit",method = RequestMethod.POST)
	public String applySubmit(@RequestParam("record")Apply record) {
		
		Integer i = applyservice.userApplySubmit(record);
		if(i==1) {
			return JSON.toJSONString(JsonResult.setTrue());
		}
		else{
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}
	
	/**
	 * ��ȡ����е������б�
	 * @param session
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/appling",method = RequestMethod.GET)
	public String getAppling(HttpSession session) {
		User user  = (User)session.getAttribute("user");
		Integer id = user.getId();
		List<Apply> list = applyservice.userGetAppling(id);
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}
	
	/**
	 * �������ͨ��������
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/applied",method = RequestMethod.GET)
	public String getApplied(HttpSession session) {
		User user  = (User)session.getAttribute("user");
		Integer id = user.getId();
		System.out.println(id);
		List<Apply> list = applyservice.userGetApplied(id);
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}
	
	/**
	 * ����������ʷ�б�(�Ѿ��黹��)
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/applyhistory",method = RequestMethod.GET)
	public String getApplyHistory(HttpSession session) {
		User user  = (User)session.getAttribute("user");
		Integer id = user.getId();
		List<Apply> list = applyservice.userGetApph(id);
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}
	
	/**
	 * �黹 [����id]Ϊ ĳֵ �� �����
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/return/{id}",method = RequestMethod.PUT)
	public String returnApply(@PathVariable("id") Integer id) {
		
		//ûȷ��state�Ƿ�Ϊ1
		Integer i = applyservice.userReturnApply(id);
		  
		if(i==2) {
		     return JSON.toJSONString(JsonResult.setTrue());
		}
		else 
		{
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}
}
