package com.cop.backge09.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cop.backge09.model.User;
import com.cop.backge09.service.impl.UserServiceImpl;
import com.cop.backge09.utils.exception.ActionException;
import com.cop.backge09.utils.model.Result;
import com.cop.backge09.utils.orm.hibernate.EntityManager;
import com.cop.backge09.utils.utils.encode.Encrypt;
import com.cop.backge09.utils.web.springmvc.BaseController;

/** 
* @ClassName: UserController 
* @Description: TODO(用户Controller) 
* @author ty 
* @date 2017-7-29 上午11:08:54 
*  
*/
@Controller
@RequestMapping("user")
public class UserController extends BaseController<User, Integer> {
	
	@Autowired   private UserServiceImpl userService;
	@Override
	public EntityManager<User, Integer> getEntityManager() {
		return userService;
	}
	 
	/**
	 * 用户列表 页面
	 */
	@RequestMapping(value = {""})
	public String list() {
		return "user_list";
	}
	 
	/**
	 * 编辑用户 页面
	 */
	@RequestMapping(value = { "edit" })
	public String input(@ModelAttribute("model") User user) throws Exception {
		return "user_edit";
	}
	
	/**
	 * 修改密码 页面
	 */
    @RequestMapping(value = {"password"})
    public String password() throws Exception {
        return "user_password";

    }
    
	/**
	 * 保存
	 */
    @RequestMapping(value = {"_save"})
    @ResponseBody
    public Result save(@ModelAttribute("model") User user) {
        userService.evict(user);//如过本方法中有对model。setXX操作 则需执行evict方法 防止Hibernate session自动同步
        Result result = null;
        // 名称重复校验
        User nameCheckUser = userService.getUserByLoginName(user.getAccount());
        if (nameCheckUser != null && !nameCheckUser.getId().equals(user.getId())) {
            result = new Result(Result.WARN, "登录名为[" + user.getAccount() + "]已存在,请修正!", "loginName");
            return result;
        }

        if (user.getId() == null) {// 新增
            user.setCreateTime(new Date());
            user.setPassword(Encrypt.e(user.getPassword()));
       } 
        user.setPassword(user.getPassword());
        userService.saveEntity(user);
        result = Result.successResult();
        return result;
    }
	 
	/**
	 * 修改密码
	 */
    @RequestMapping(value = {"updateUserPassword"})
    @ResponseBody
    public Result updateUserPassword(Integer id, String newPassword) throws Exception {
        Result result;
        User user = userService.getById(id);
        if(user!=null){
        	user.setPassword(Encrypt.e(newPassword));
        	userService.saveEntity(user);
        	result = Result.successResult();
        } else {
            throw new ActionException("用户【"+id+"】不存在或已被删除.");
        }
        return result;
    }
   

}
