/**  
* @Title: UserSelection.java
* @Description:  
* @author roger  
* @date 2019年7月17日  
* @version 1.0  
*/
package com.roger.ims.vo;

import java.util.Date;

/**
 * @Title: UserSelection
 * @Description: 用户查询面板
 * @author roger
 * @date 2019年7月17日
 */
public class UserVo {
	/** 用户ID */
	private long userId;
	/** 登录账号*/  
	private String loginName;
	/** 密码*/  
	private String password;
	/** 用户姓名名*/  
	private String username;
	/** 手机号码*/  
	private String telphone;
	/** 电子邮箱*/  
	private String email;
	/** 创建时间*/  
	private Date creationTime;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
}
