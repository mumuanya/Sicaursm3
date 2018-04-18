
package com.rk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @author HuangKai  

* @date 2018Äê4ÔÂ18ÈÕ  

* @version 1.0  

*/
@Controller
@RequestMapping("/common")
public class CommonController {
	
	
	@RequestMapping("/notice")
	public ModelAndView notice(HttpSession session) {
		
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/notice");
		return mdv;
	}
}
