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
import com.rk.bean.ItemBean;
import com.rk.model.Item;
import com.rk.service.ItemService;
import com.rk.util.JsonResult;

@RequestMapping(value="/admin/item")
@Controller
public class AdminItemController {
	
	@Autowired
	ItemService itemservice;
	
	/**
	 * 返回所有物品信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String getAll() {
		
		List<Item> list = itemservice.selectAll();
		List<ItemBean> list2 = new ArrayList<>();
		ItemBean item = null;
		for(Item i: list) {
			item = new ItemBean();
			item.setItem(i);
			list2.add(item);
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
 * 删除一个item记录
 * @param id
 * @return
 */
	@ResponseBody
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public String deleterecord(@PathVariable("id") Integer id) {
		
	  Integer i = itemservice.delete(id);
	  
	  if(i > 0) {
		  System.out.println(JSON.toJSONString(JsonResult.setTrue()));
		  return JSON.toJSONString(JsonResult.setTrue());
	  }
	  else{
		  return JSON.toJSONString(JsonResult.setFalse());
	  }
	}
	
	/**
	 * 更新id为某值的item记录
	 * @param id
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update/{id}",method = RequestMethod.POST)
	public String updaterecord(@PathVariable("id") Integer id,@RequestParam("name")String name,
			@RequestParam("description") String description,
			@RequestParam("position") String position,
			@RequestParam("state") Integer state) {
		
		Item item = itemservice.selectById(id);
		//判空
		if(item == null) {
			return JSON.toJSONString(JsonResult.setFalse());
		}
		item.setName(name);
		item.setDescription(description);
		item.setPosition(position);
		item.setState(state);
	    Integer i = itemservice.update(item);
	  if(i > 0)
		return JSON.toJSONString(JsonResult.setTrue());
	  else
		  return JSON.toJSONString(JsonResult.setFalse());
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addrecord(@RequestParam String name, @RequestParam String description, @RequestParam String position) {
		Item item = new Item();
		item.setDescription(description);
		item.setName(name);
		item.setPosition(position);
		item.setState(0);
		Integer i = itemservice.addItem(item);
		if(i.intValue() > 0) {
			return JSON.toJSONString(JsonResult.setTrue());
		}else {
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}

}
