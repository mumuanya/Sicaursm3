package com.rk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rk.model.Apply;
import com.rk.service.ApplyService;
import com.rk.util.JsonResult;

@RequestMapping(value= "/admin/apply")
@Controller
public class ApplyController {
	
	@Autowired
	ApplyService applyservice;
	
	
	/**
	 * ��ѯ����δͨ����˵�����
	 */
	@ResponseBody
	@RequestMapping(value="/apply/appling",method = RequestMethod.GET)
	public String getAppling() {
		
		List<Apply> list = applyservice.getAppling();
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
		}
		
	}
	
	/**
	 * ��ѯ�����Ѿ�ͨ����˵�����
	 */
	@ResponseBody
	@RequestMapping(value="/apply/applied",method = RequestMethod.GET)
	public String getApplied() {
		
		List<Apply> list = applyservice.getApplied();
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
		}
		
	}
	
	/**
	 *  ��ѯ�����Ѿ�����黹������
	 */
	@ResponseBody
	@RequestMapping(value="/apply/returning",method = RequestMethod.GET)
	public String getreturning() {
		
		List<Apply> list = applyservice.getReturning();
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
		}
		
	}
	
	/**
	 *   ��ѯ�����Ѿ��黹������
	 */
	@ResponseBody
	@RequestMapping(value="/apply/returned",method = RequestMethod.GET)
	public String getreturned() {
		
		List<Apply> list = applyservice.getReturned();
		if(list != null) {
			String jsonStr = JSON.toJSONString(list);
			System.out.println("[LOG] json data:" + jsonStr);
			return jsonStr;
		}else {
			return JsonResult.RS_FALSE;
		}
		
	}
	
	  /**
	   * ʹidΪĳֵ������ͨ�����,�������Ʒ/����
	   * @param id
	   * @return
	   */
	  
	@ResponseBody
	@RequestMapping(value="/apply/pass/{id}",method = RequestMethod.PUT)
	public String agreeApply(@PathVariable("id") Integer id) {
		
		//ûȷ��state�Ƿ�Ϊ0
		Integer i = applyservice.agreeApl(id);
		  
		  if(i==1) {
			return JsonResult.RS_TRUE;
		  }
		  else return JsonResult.RS_FALSE;
		
	}
	
	/**
	 * �ܾ�idΪĳֵ����������
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/apply/refuse/{id}",method = RequestMethod.PUT)
	public String refuseApply(@PathVariable("id") Integer id) {
		
		//ûȷ��state�Ƿ�Ϊ0
		Integer i = applyservice.refuseApl(id);
		  
		  if(i==-1) {
			return JsonResult.RS_TRUE;
		  }
		  else return JsonResult.RS_FALSE;
		
	}
	
	/**
	 * /apply/return/{id}    ͬ��idΪĳֵ������Ĺ黹����
	 */
	@ResponseBody
	@RequestMapping(value="/apply/return/{id}",method = RequestMethod.PUT)
	public String agreeReturn(@PathVariable("id") Integer id) {
		
		//ûȷ��state�Ƿ�Ϊ0
		Integer i = applyservice.agreeReturn(id);
		  
		  if(i==3) {
			return JsonResult.RS_TRUE;
			}
		  else return JsonResult.RS_FALSE;
		
	}
	
	



}
