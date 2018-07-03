package com.cop.backge09.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 用户表
 * @ClassName: User
 * @author ty
 * @date 2017-7-19 上午09:31:40
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "operatorinfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" , "handler","fieldHandler"})
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) 
public class User implements Serializable {

	private Integer id; 
	/**
	 *用户名
	 */
	private String account;  
	/**
	 * 密码
	 */
	private String password; 
	/**
	 * 昵称
	 */
	private String nickname; 
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name="create_time",updatable=false)
	private Date createTime=new Date(); 
	/**
	 * 状态
	 */
	private Integer status; 
	/**
	 * 验证码
	 */
	private String code; 
	/**
	 * 登录次数
	 */
	private Integer loginCount; 
	/**
	 * ip
	 */
	private String ip; 
	/**
	 * last_ip
	 */
	private String lastIp;
	/**
	 * lastTime
	 */
	private Date lastTime;
	/**
	 * atTime
	 */
	private Date atTime;
	/**
	 * 账号类型  2管理员  1普通会员
	 */
	private Integer accountType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "account",length = 50)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password",length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname",length = 50)
	public String getNickname() {

		return nickname;
	}

	public void setNickname(String nickname) {

		this.nickname = nickname;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name = "create_time",updatable=false)
	public Date getCreateTime() {

		return createTime;
	}

	public void setCreateTime(Date createTime) {

		this.createTime = createTime;
	}


	@Column(name = "status")
	public Integer getStatus() {

		return status;
	}

	public void setStatus(Integer status) {

		this.status = status;
	}

	@Transient
	public String getCode() {
		return code;
	}

	private String lastTimeStrin;

	public void setCode(String code) {
		this.code = code;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "login_count")
	public Integer getLoginCount() {
		if(loginCount==null)
			loginCount=0;
		return loginCount;
	}
	
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	
	@Column(name = "ip")
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Column(name = "last_ip")
	public String getLastIp() {
		return lastIp;
	}
	
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name = "last_time")
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	@Transient
	public String getLastTimeStrin() {
		if(lastTime!=null)
		{
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			lastTimeStrin=sdf.format(lastTime);
		}
		return  lastTimeStrin;
	}
	public void setLastTimeStrin(String lastTimeStrin) {
		this.lastTimeStrin = lastTimeStrin;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name = "at_time")
	public Date getAtTime() {
		return atTime;
	}
	public void setAtTime(Date atTime) {
		this.atTime = atTime;
	}
	@Column(name="account_type")
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accounType) {
		this.accountType = accounType;
	}


}
