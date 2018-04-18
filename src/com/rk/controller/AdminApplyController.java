package com.rk.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.rk.service.MailAssistant;
import com.rk.service.UserService;
import com.rk.util.JsonResult;

@RequestMapping(value = "/admin/apply")
@Controller
public class AdminApplyController {

	@Autowired
	MailAssistant mailAssistant;

	@Autowired
	ApplyService applyservice;

	@Autowired
	FieldService fieldService;

	@Autowired
	ItemService itemService;

	@Autowired
	UserService userService;

	/**
	 * 查询所有未通过审核的申请
	 */
	@ResponseBody
	@RequestMapping(value = "/appling", method = RequestMethod.GET)
	public String getAppling() {

		List<Apply> list = applyservice.getAppling();
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean apply = null;
		for (Apply a : list) {
			apply = new ApplyBean();
			String username = (userService.getUserById(a.getUserid())).getNeckname();
			String itemfieldname = null;
			if (a.getBorrowtype() == 0) {
				// 场地
				itemfieldname = fieldService.selectById(a.getTid()).getName();
			} else if (a.getBorrowtype() == 1) {
				// 物品
				itemfieldname = itemService.selectById(a.getTid()).getName();
			}
			apply.setApply(a, username, itemfieldname);
			list2.add(apply);
		}
		if (list != null) {
			String jsonStr = JSON.toJSONString(list2);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		} else {
			return JSON.toJSONString(JsonResult.setFalse());
		}

	}

	/**
	 * 查询所有已经通过审核的申请
	 */
	@ResponseBody
	@RequestMapping(value = "/applied", method = RequestMethod.GET)
	public String getApplied() {

		List<Apply> list = applyservice.getApplied();
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean apply = null;
		for (Apply a : list) {
			apply = new ApplyBean();
			String username = (userService.getUserById(a.getUserid())).getNeckname();
			String itemfieldname = null;
			if (a.getBorrowtype() == 0) {
				// 场地
				itemfieldname = fieldService.selectById(a.getTid()).getName();
			} else if (a.getBorrowtype() == 1) {
				// 物品
				itemfieldname = itemService.selectById(a.getTid()).getName();
			}
			apply.setApply(a, username, itemfieldname);
			list2.add(apply);
		}
		if (list != null) {
			String jsonStr = JSON.toJSONString(list2);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		} else {
			return JSON.toJSONString(JsonResult.setFalse());
		}

	}

	/**
	 * 查询所有已经申请归还的申请
	 */
	@ResponseBody
	@RequestMapping(value = "/returning", method = RequestMethod.GET)
	public String getreturning() {

		List<Apply> list = applyservice.getReturning();
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean apply = null;
		for (Apply a : list) {
			apply = new ApplyBean();
			String username = (userService.getUserById(a.getUserid())).getNeckname();
			String itemfieldname = null;
			if (a.getBorrowtype() == 0) {
				// 场地
				itemfieldname = fieldService.selectById(a.getTid()).getName();
			} else if (a.getBorrowtype() == 1) {
				// 物品
				itemfieldname = itemService.selectById(a.getTid()).getName();
			}
			apply.setApply(a, username, itemfieldname);
			list2.add(apply);
		}
		if (list != null) {
			String jsonStr = JSON.toJSONString(list2);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		} else {
			return JSON.toJSONString(JsonResult.setFalse());
		}

	}

	/**
	 * 查询所有已经归还的申请
	 * 
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/returned", method = RequestMethod.GET)
	public String getreturned() {

		List<Apply> list = applyservice.getReturned();
		List<ApplyBean> list2 = new ArrayList<>();
		ApplyBean apply = null;
		for (Apply a : list) {
			apply = new ApplyBean();
			String username = (userService.getUserById(a.getUserid())).getNeckname();
			String itemfieldname = null;
			if (a.getBorrowtype() == 0) {
				// 场地
				itemfieldname = fieldService.selectById(a.getTid()).getName();
			} else if (a.getBorrowtype() == 1) {
				// 物品
				itemfieldname = itemService.selectById(a.getTid()).getName();
			}
			apply.setApply(a, username, itemfieldname);
			list2.add(apply);
		}
		if (list != null) {
			String jsonStr = JSON.toJSONString(list2);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		} else {
			return JSON.toJSONString(JsonResult.setFalse());
		}

	}

	/**
	 * 使id为某值的申请通过审核,即借出物品/场地
	 * 
	 * @param id
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/pass/{id}", method = RequestMethod.POST)
	public String agreeApply(@PathVariable("id") Integer id,@RequestParam String borrowtype) {
		// 没确认state是否为0
		Integer i = applyservice.agreeApl(id,borrowtype);
		Apply apply = applyservice.getApplyByid(id);
		User user = userService.getUserById(apply.getUserid());
		if (i == 1) {
			// 发送邮件的线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					mailAssistant.agreeApply(user.getMail(), user.getNeckname()); // 发送邮件通知审核通过
				}
			}).start();
			String rs = JSON.toJSONString(JsonResult.setTrue());
			System.out.println(rs);
			return rs;
		} else
			return JSON.toJSONString(JsonResult.setFalse());
	}

	/**
	 * 拒绝id为某值的申请请求
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/refuse/{id}", method = RequestMethod.POST)
	public String refuseApply(@PathVariable("id") Integer id) {

		// 没确认state是否为0
		Integer i = applyservice.refuseApl(id);
		Apply apply = applyservice.getApplyByid(id);
		User user = userService.getUserById(apply.getUserid());
		if (i == -1) {
			// 发送邮件的线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					mailAssistant.refuseApply(user.getMail(), user.getNeckname()); // 发送邮件通知审核通过
				}
			}).start();
			String rs = JSON.toJSONString(JsonResult.setTrue());
			System.out.println(rs);
			return rs;
		} else
			return JSON.toJSONString(JsonResult.setFalse());

	}

	/**
	 * 同意id为某值的申请的归还申请
	 * 
	 * @param id
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/return/{id}", method = RequestMethod.POST)
	public String agreeReturn(@PathVariable("id") Integer id,@RequestParam String borrowtype) {
		// 没确认state是否为2
		Integer i = applyservice.agreeReturn(id,borrowtype);
		Apply apply = applyservice.getApplyByid(id);
		User user = userService.getUserById(apply.getUserid());
		if (i == 3) { //归还成功
			// 发送邮件的线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					mailAssistant.agreeReturn(user.getMail(), user.getNeckname()); // 发送邮件通知审核通过
				}
			}).start();
			String rs = JSON.toJSONString(JsonResult.setTrue());
			System.out.println(rs);
			return rs;
		} else
			return JSON.toJSONString(JsonResult.setFalse());
	}
	
	/**
	 * 催促用户还资源
	 * @param userid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/urge/{userid}", method = RequestMethod.GET)
	public String urgeApply(@PathVariable Integer userid) {
		//获取用户
		User user = userService.getUserById(userid);
		new Thread(new Runnable() {
			@Override
			public void run() {
				mailAssistant.urgeApply(user.getMail(), user.getNeckname()); // 发送邮件通知审核通过
			}
		}).start();
		String rs = JSON.toJSONString(JsonResult.setTrue());
		System.out.println(rs);
		return rs;
	}

}
