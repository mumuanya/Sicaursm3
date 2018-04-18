package com.rk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rk.bean.ItemBean;
import com.rk.model.Item;
import com.rk.service.ItemService;
import com.rk.util.JsonResult;

@RequestMapping(value="/user/items")
@Controller
public class UserItemsController {
	
	@Autowired
	ItemService itemservice;
	
	/**
	 * 返回所有可用物品列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String getAllitems() {
		
		List<Item> list = itemservice.selectUnitems();
		//处理state域
		List<ItemBean> list2 = new ArrayList<>();
		ItemBean ib = null;
		for(Item i: list) {
			ib = new ItemBean();
			ib.setItem(i);
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
}
