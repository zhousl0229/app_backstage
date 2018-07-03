package com.cop.backge09.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cop.backge09.model.User;
import com.cop.backge09.service.impl.CpxdailyServiceImpl;
import com.cop.backge09.service.impl.UserServiceImpl;
import com.cop.backge09.utils.model.Result;
import com.cop.backge09.utils.utils.StringUtils;
import com.cop.backge09.utils.utils.encode.Encrypt;
import com.cop.backge09.utils.web.springmvc.SimpleController;


/** 
* @ClassName: LoginController 
* @Description: TODO(登录Controller) 
* @author ty 
* @date 2017-7-29 上午11:08:54 
*  
*/
@Controller
public class LoginController extends SimpleController {

	@Autowired   private UserServiceImpl userService;
	@Autowired   private CpxdailyServiceImpl cpxdailyService;
	/**
	 * 登录验证
	 */ 
	@ResponseBody
	@RequestMapping(value = { "loginJson" })
	public Result login(String loginName, String password,String code, HttpServletRequest request,HttpSession session) {
		Result result = null;
		String msg = null;
		if(StringUtils.isBlank(loginName)){
			msg = "请输入用户名!";
			result = new Result(Result.ERROR, msg, null);
			return result;
		}
		if(StringUtils.isBlank(password)){
			msg = "请输入密码!";
			result = new Result(Result.ERROR, msg, null);
			return result;
		}
		
		// 获取用户信息
		User user = userService.login(request,loginName, Encrypt.e(password));
		if (user == null) {
			msg = "用户名或密码不正确!";
			result = new Result(Result.ERROR, msg, "codeError");
			return result;
		}
		// 将用户信息放入session中
		request.getSession().setAttribute("userSession",user);
		request.getSession().setAttribute("userId", user.getId());
		request.getSession().setAttribute("account", user.getAccount());
		request.getSession().setAttribute("nickname", user.getNickname());
		//request.getSession().setAttribute("platformId", user.getPlatformId());
		
		result = new Result(Result.SUCCESS, "用户验证通过!", "index");
		return result;
	}
	
	
	/**
	 * 登录页面
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = { "login" })
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	
    /** 
     * 退出登录
     */  
    @RequestMapping(value={"logout"})  
    public String logout( HttpServletRequest request) throws Exception{  
		//Result result = null;
    	request.getSession().invalidate();  
    	//result = new Result(Result.SUCCESS,null,null);
        //return result;  
    	return "forward:login";
    }  
	/**
	 * 砾点浏览器后台主页
	 */
	@RequestMapping(value = { "index" })
	public String ldIndex(HttpServletRequest request,Model model) {
	 	Long sum=	cpxdailyService.count();
		BigDecimal sumSales=cpxdailyService.sum(); //汇总金额
		model.addAttribute("sum", sum);
		model.addAttribute("sumSales", sumSales);
		User user=(User) request.getSession().getAttribute("userSession");
		if(user.getAccountType()==2)
			return "cpxdaily_admin_list";
		
		return "index";
	}

	/**
	 * 修改密码 页面
	 */
    @RequestMapping(value = {"password"})
    public String password() throws Exception {
        return "user_password";

    }
}
