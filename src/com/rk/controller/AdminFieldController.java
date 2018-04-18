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
import com.rk.bean.FieldBean;
import com.rk.model.Field;
import com.rk.service.FieldService;
import com.rk.util.JsonResult;

@RequestMapping(value="/admin/field")
@Controller
public class AdminFieldController {
	
	@Autowired
	FieldService fieldservice;
	
	/**
	 * 返回所有场地信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String getAll() {
		
		List<Field> list = fieldservice.selectAll();
		//处理state域
		List<FieldBean> list2 = new ArrayList<>();
		FieldBean fb = null;
		for(Field f: list) {
			fb = new FieldBean();
			fb.setField(f);
			list2.add(fb);
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
 * 删除一个field记录
 * @param id
 * @return
 */
	@ResponseBody
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public String deleterecord(@PathVariable("id") Integer id) {
		
	  Integer rs = fieldservice.delete(id);
	  
	  if(rs > 0) {
		  System.out.println(JSON.toJSONString(JsonResult.setTrue()));
		  return JSON.toJSONString(JsonResult.setTrue());
	  }
	  else{
		  return JSON.toJSONString(JsonResult.setFalse()); 
	  }
	}
	
	/**
	 * 更新id为某值的field记录
	 * @param id
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update/{id}",method = RequestMethod.POST)
	public String updaterecord(@PathVariable("id") Integer id,
			@RequestParam("name")String name,
			@RequestParam("description")String description,
			@RequestParam("position")String position,
			@RequestParam("state")Integer state) {
		Field field = fieldservice.selectById(id);
		if(name != null) field.setName(name);
		if(description != null) field.setDescription(description);
		if(position != null) field.setPosition(position);
		if(state != null) field.setState(state);
	    Integer i = fieldservice.update(field);
	  if(i > 0)
		return JSON.toJSONString(JsonResult.setTrue());
	  else 
		return JSON.toJSONString(JsonResult.setFalse());
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addrecord(@RequestParam String name, @RequestParam String description, @RequestParam String position) {
		Field field = new Field();
		field.setDescription(description);
		field.setName(name);
		field.setPosition(position);
		field.setState(0);
		Integer i = fieldservice.addField(field);
		if(i.intValue() > 0) {
			return JSON.toJSONString(JsonResult.setTrue());
		}else {
			return JSON.toJSONString(JsonResult.setFalse());
		}
	}
}
