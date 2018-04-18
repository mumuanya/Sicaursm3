package com.rk.controller;

import java.util.ArrayList;
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
import com.rk.bean.ApplyBean;
import com.rk.model.Apply;
import com.rk.model.User;
import com.rk.service.ApplyService;
import com.rk.service.FieldService;
import com.rk.service.ItemService;
import com.rk.service.UserService;
import com.rk.util.JsonResult;

@RequestMapping(value= "/user/apply")
@Controller
public class UserApplyController {
	
	@Autowired
	ApplyService applyservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	ItemService itemservice;
	
	@Autowired
	FieldService fieldservice;
	/**
	 * �ύ����
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/apply",method = RequestMethod.POST)
	public String applySubmit(HttpSession session,
			@RequestParam Integer borrowtype,
			@RequestParam Integer tid,
			@RequestParam String borrowreason,
			@RequestParam Integer borrowtime) {
		//����У��
		if(borrowtype == null) return JSON.toJSONString(JsonResult.setFalse());
		if(tid == null) return JSON.toJSONString(JsonResult.setFalse());
		if(borrowreason == null || borrowreason.equals("")) return JSON.toJSONString(JsonResult.setFalse());
		if(borrowtime == null || borrowtime < 1) return JSON.toJSONString(JsonResult.setFalse());
		
		User user = (User)session.getAttribute("user");
		Apply apply = new Apply();
		
		apply.setBorrowreason(borrowreason);
		apply.setBorrowtype(borrowtype);
		apply.setTid(tid);
		apply.setBorrowtime(borrowtime);
		apply.setUserid(user.getId());
		apply.setState(0);
		Integer i = applyservice.userApplySubmit(apply);
		
		if(i > 0) {
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
		//����state��
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean ib = null;
		for(Apply i: list) {
			ib = new ApplyBean();
			String username = (userservice.getUserById(i.getUserid())).getNeckname();
			String itemfieldname = null;
			if (i.getBorrowtype() == 0) {
				// ����
				itemfieldname = fieldservice.selectById(i.getTid()).getName();
			} else if (i.getBorrowtype() == 1) {
				// ��Ʒ
				itemfieldname = itemservice.selectById(i.getTid()).getName();
			}
			ib.setApply(i, username, itemfieldname);
			list2.add(ib);
		}
		if(list != null) {
			String jsonStr = JSON.toJSONString(list2);
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
		//����state��
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean ib = null;
		for(Apply i: list) {
			ib = new ApplyBean();
			String username = (userservice.getUserById(i.getUserid())).getNeckname();
			String itemfieldname = null;
			if (i.getBorrowtype() == 0) {
				// ����
				itemfieldname = fieldservice.selectById(i.getTid()).getName();
			} else if (i.getBorrowtype() == 1) {
				// ��Ʒ
				itemfieldname = itemservice.selectById(i.getTid()).getName();
			}
			ib.setApply(i, username, itemfieldname);
			list2.add(ib);
		}
		if(list != null) {
			String jsonStr = JSON.toJSONString(list2);
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
		//����state��
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean ib = null;
		for(Apply i: list) {
			ib = new ApplyBean();
			String username = (userservice.getUserById(i.getUserid())).getNeckname();
			String itemfieldname = null;
			if (i.getBorrowtype() == 0) {
				// ����
				itemfieldname = fieldservice.selectById(i.getTid()).getName();
			} else if (i.getBorrowtype() == 1) {
				// ��Ʒ
				itemfieldname = itemservice.selectById(i.getTid()).getName();
			}
			ib.setApply(i, username, itemfieldname);
			list2.add(ib);
		}
		if(list != null) {
			String jsonStr = JSON.toJSONString(list2);
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
	@RequestMapping(value="/return/{id}",method = RequestMethod.POST)
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
