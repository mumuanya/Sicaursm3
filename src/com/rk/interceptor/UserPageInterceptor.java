package com.rk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserPageInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mdv)
			throws Exception {
		//ÅÐ¶Ïsession
				HttpSession session = request.getSession();
				if(session.getAttribute("user") == null) {
					mdv.clear();
					mdv.addObject("msg", "ÄãÃ»ÓÐµÇÂ¼");
					mdv.setViewName("/error1");
				}
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}

}
