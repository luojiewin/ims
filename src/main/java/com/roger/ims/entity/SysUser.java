package com.roger.ims.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* @Title: SysUser  
* @Description: 用户表sys_user
* @author roger  
* @date 2019年7月17日  
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
	
    /** 用户ID*/  
    private Long userId;
    
    /** 登录名*/  
    private String loginName;

    /** 密码*/  
    private String password;

    /** 用户名*/  
    private String username;

    /** 手机号码*/  
    private String telphone;

    /** email*/  
    private String email;

    /** 最后登录时间*/  
    private Date lastLoginTime;

    /** creationTime*/  
    private Date creationTime;

    /** creationUserId*/  
    private Long creationUserId;

    /** lastUpdateTime*/  
    private Date lastUpdateTime;

    /** lastUpdateUserId*/  
    private Long lastUpdateUserId;
  
}