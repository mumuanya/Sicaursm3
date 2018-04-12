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
import com.rk.model.Field;
import com.rk.service.FieldService;
import com.rk.util.JsonResult;

@RequestMapping(value="/field")
@Controller
public class FieldController {
	
	@Autowired
	FieldService fieldservice;
	
	
	/**
	 * 返回所有场地信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/field/all",method = RequestMethod.GET)
	public String getAll() {
		
		List<Field> list = fieldservice.selectAll();
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
		}
	}
	
	
/**
 * 删除一个field记录
 * @param id
 * @return
 */
	@ResponseBody
	@RequestMapping(value="/field/delete/{id}",method = RequestMethod.DELETE)
	public String deleterecord(@PathVariable("id") Integer id) {
		
	  Integer i = fieldservice.delete(id);
	  
	  if(i==1)
		return JsonResult.RS_TRUE;
	  else return JsonResult.RS_FALSE;
	}
	
	/**
	 * 更新id为某值的field记录
	 * @param id
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/field/update/{id}",method = RequestMethod.PUT)
	public String updaterecord(@PathVariable("id") Integer id,@RequestParam("record")Field record) {
		//Field field = fieldservice.selectById(id);
	    Integer i = fieldservice.update(record);
	  if(i==1)
		return JsonResult.RS_TRUE;
	  else return JsonResult.RS_FALSE;
	}
	
	

}
