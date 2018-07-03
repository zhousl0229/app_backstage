package com.cop.backge09.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cop.backge09.model.Cpxdaily;
import com.cop.backge09.service.impl.CpxdailyServiceImpl;
import com.cop.backge09.utils.excel.ExcelUtil;
import com.cop.backge09.utils.model.Result;


@Controller
public class UploadController {
	@Autowired  private CpxdailyServiceImpl  cpxdailyServiceImpl;

	/** 
	 * <p>Title:上传Excel文件和简析数据到数据库 </p> 
	 * @param file       文件流
	 * @param request    请求
	 * @param suffix     文件后缀 
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadFile")
	public   @ResponseBody Result uploadFile(@RequestParam("file") CommonsMultipartFile file, String suffix)  
	{   
		try
		{
			Integer type=1;
			if(suffix.equals(".xlsx"))
				type=0;
			Collection<Cpxdaily> entity= ExcelUtil.importExcelByIs(file.getInputStream(), Cpxdaily.class,type);
			for(Cpxdaily cpxdaily: entity)  //格式校检
			   if (!cpxdaily.checkoutRoutine())
			     return Result.errorResult().setMsg("数据格式异常，请检查。");
			
		    cpxdailyServiceImpl.saveOrUpdate(entity);
			return Result.successResult().setMsg("上传数据成功！");
		} 
		catch (Exception e)
		{   
			return Result.errorResult().setMsg("请勿上传重复数据，或数据格式有误。");
		}
	}
}