/**  
* @Title: UserSelection.java
* @Description:  
* @author roger  
* @date 2019年7月17日  
* @version 1.0  
*/
package com.roger.ims.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: UserSelection
 * @Description: 用户查询面板
 * @author roger
 * @date 2019年7月17日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date creationTime;
}
