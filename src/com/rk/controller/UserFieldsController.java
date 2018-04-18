package com.rk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rk.bean.FieldBean;
import com.rk.model.Field;
import com.rk.service.FieldService;
import com.rk.util.JsonResult;

@RequestMapping(value="/user/fields")
@Controller
public class UserFieldsController {
	
	@Autowired
	FieldService fieldservice;
	
	/**
	 * 返回所有可用场地列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String getAllfields() {
		
		List<Field> list = fieldservice.selectUnfields();
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

}
