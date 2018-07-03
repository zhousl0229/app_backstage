package com.cop.backge09.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
  

/** 
* @ClassName: LoginHandlerIntercepter 
* @Description: TODO(登录拦截) 
* @author ty 
* @date 2017-7-29 下午2:03:34 
*  
*/
public class LoginHandlerIntercepter implements HandlerInterceptor {  
	
	
    @Override  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {  
    
    }  
  
    @Override  
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {  
    }   
    @Override  
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String  requestURI = request.getRequestURI();
		if (requestURI.indexOf("login")!=-1||requestURI.indexOf("upload")!=-1) {//登录页面 直接放过
			 return true;
		}
		else if (userId != null) {//非接口非登录操作 是否带id
			return true;
		}

	    request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

}  
