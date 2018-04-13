package com.rk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
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
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
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
	  
	  if(i==1)
		return JsonResult.RS_TRUE;
	  else return JsonResult.RS_FALSE;
	}
	
	/**
	 * 更新id为某值的item记录
	 * @param id
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
	public String updaterecord(@PathVariable("id") Integer id,@RequestParam("record")Item record) {
		//Item item = itemservice.selectById(id);
	    Integer i = itemservice.update(record);
	  if(i==1)
		return JsonResult.RS_TRUE;
	  else return JsonResult.RS_FALSE;
	}
	
	

}
