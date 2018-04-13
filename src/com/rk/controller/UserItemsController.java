package com.rk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
		}
	}

}
