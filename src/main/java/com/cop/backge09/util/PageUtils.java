package com.cop.backge09.util;

import java.util.List;

@SuppressWarnings("rawtypes")
public class PageUtils {
    private Long iTotalRecords;//实际的行数
    private Long iTotalDisplayRecords;//过滤之后，实际的行数
    private Integer draw;//datatables传过来的参数 原样返回
	private List aaData;//返回实体
	private Integer sumPage;//总页数
	private boolean status;//0无数据  1 有数据
    public PageUtils() {
		
	}
	
	public PageUtils(Long iTotalRecords, Long iTotalDisplayRecords, Integer draw, List aaData) {

		super();
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.draw = draw;
		this.aaData = aaData;
	}

	public Long getiTotalRecords() {
	
		return iTotalRecords;
	}
	
	public void setiTotalRecords(Long iTotalRecords) {
	
		this.iTotalRecords = iTotalRecords;
	}
	
	public Long getiTotalDisplayRecords() {
	
		return iTotalDisplayRecords;
	}
	
	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
	
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	
	public Integer getDraw() {
	
		return draw;
	}
	
	public void setDraw(Integer draw) {
	
		this.draw = draw;
	}
	
	public List getAaData() {
	
		return aaData;
	}
	
	public void setAaData(List aaData) {
	
		this.aaData = aaData;
	}

	public Integer getSumPage() {
		if(aaData==null||aaData.size()==0) 
			return 0;
		Integer length=aaData.size();
		if(iTotalDisplayRecords%length==0)
		  return (int) (iTotalDisplayRecords/length);
		else
		  return (int) (iTotalDisplayRecords/length+1);
	}

	
	public void setSumPage(Integer sumPage) {
		this.sumPage = sumPage;
	}

	public boolean isStatus() {
		if(aaData==null||aaData.size()==0)
			return false;
		return true;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
