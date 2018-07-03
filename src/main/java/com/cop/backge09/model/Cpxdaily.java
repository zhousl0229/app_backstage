package com.cop.backge09.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.cop.backge09.utils.excel.annotation.Excel;
import com.cop.backge09.utils.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <p>
 * 
 * </p>
 *
 * @author ty
 * @since 2018-04-12
 */
@SuppressWarnings("serial")
@Entity
@Table(name="c_cpxdaily")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" , "handler","fieldHandler"})
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) 
public class Cpxdaily implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	/**
	 *合作日期
	 */
	@Excel(exportName="合作日期", exportFieldWidth = 0,importConvert=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date cdate;
	/**
	 *合作应用
	 */
	@Excel(exportName="合作应用", exportFieldWidth = 0)
	private String cname;
	/**
	 *客户名称
	 */
	@Excel(exportName="客户名称", exportFieldWidth = 0)
	private String aname;
	/**
	 *展示次数
	 */
	@Excel(exportName="展示次数", exportFieldWidth = 0)
	private Integer shows;
	/**
	 *点击次数
	 */
	@Excel(exportName="点击次数", exportFieldWidth = 0)
	private Integer clicks;
	/**
	 *激活数
	 */
	@Excel(exportName="激活数", exportFieldWidth = 0)
	private Integer actives;
	/**
	 *分成金额
	 */
	@Excel(exportName="分成金额", exportFieldWidth = 0,importConvert=true)
	private Double sales;
	/**
	 *应用激活 2 激活  1 取消激活
	 */
	@Excel(exportName="应用激活", exportFieldWidth = 0,importConvert=true)
	private Integer cstatus;
	/**
	 *结算模式
	 */
	@Excel(exportName="结算模式", exportFieldWidth = 0)
	private String ctype;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getShows() {
		return shows;
	}

	public void setShows(Integer shows) {
		this.shows = shows;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Integer getActives() {
		return actives;
	}

	public void setActives(Integer actives) {
		this.actives = actives;
	}

	public Double getSales() {
		return sales;
	}

	public void setSales(Double sales) {
		this.sales = sales;
	}

	public Integer getCstatus() {
		return cstatus;
	}

	public void setCstatus(Integer cstatus) {
		this.cstatus = cstatus;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	
	/**
	 *   开放：1
	 *   其他：0
	 */
	public void convertSetCstatus(String text)
	{
		if(text.equals("开放"))
			this.cstatus= 1;
		else
			this.cstatus= 0;
	}
	
	/**
	 *   日期转换 若转换失败自动取当前日期
	 */
	public void convertSetCdate(String text)
	{
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		 try {
		      this.cdate=sdf.parse(text);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.cdate=new Date();
		}
	}
	/**
	 *   金额转换
	 */
	public void convertSetSales(String text)
	{
		 if(StringUtils.isBlank(text))
			 this.sales=0.0;
		 this.sales=Double.parseDouble(text);
	}
	
	/**
	 *  通过true
	 *  失败false
	 */
	public boolean checkoutRoutine() {
		if(!StringUtils.isNotEmptys(cname,aname,ctype))
			return false;
		
		if(id==null&&shows!=null&&clicks!=null&&actives!=null&&sales!=null&&cstatus!=null)
		    return true;
		return false;
	}

	@Override
	public String toString() {
		return "Cpxdaily [id=" + id + ", cdate=" + cdate + ", cname=" + cname
				+ ", aname=" + aname + ", shows=" + shows + ", clicks="
				+ clicks + ", actives=" + actives + ", sales=" + sales
				+ ", cstatus=" + cstatus + ", ctype=" + ctype + "]";
	}
	
}

