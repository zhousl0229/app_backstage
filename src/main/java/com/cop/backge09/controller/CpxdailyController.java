package com.cop.backge09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cop.backge09.model.Cpxdaily;
import com.cop.backge09.service.impl.CpxdailyServiceImpl;
import com.cop.backge09.utils.orm.hibernate.EntityManager;
import com.cop.backge09.utils.web.springmvc.BaseController;

/** 
* @ClassName: CpxdailyController 
* @Description: TODO(用户Controller) 
* @author ty 
* @date 2017-7-29 上午11:08:54 
*  
*/
@Controller
@RequestMapping("cpxdaily")
public class CpxdailyController extends BaseController<Cpxdaily, Long> {
	
	@Autowired   private CpxdailyServiceImpl cpxdailyService;
	@Override
	public EntityManager<Cpxdaily, Long> getEntityManager() {
		return cpxdailyService;
	}
	 
	/**
	 * 列表 页面
	 */
	@RequestMapping(value = {})
	public String list() {
		return "cpxdaily_list";
	}
	
	/**
	 * 编辑 页面
	 */
	@RequestMapping(value = {"edit"})
	public String cpxdailyEdi() {
		return "cpxdaily_edit";
	}
   

}
