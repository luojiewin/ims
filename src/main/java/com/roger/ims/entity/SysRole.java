package com.roger.ims.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* @Title: SysRole  
* @Description: 角色表 sys_role
* @author roger  
* @date 2019年7月17日  
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole {
  
    /** 角色ID*/  
    private Long roleId;

    /** 角色名称*/  
    private String roleName;

    /** 描述*/  
    private String description;

    /** creationTime*/  
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creationTime;

    /** creationUserId*/  
    private Long creationUserId;

    /** lastUpdateTime*/  
    private Date lastUpdateTime;

    /** lastUpdateUserId*/  
    private Long lastUpdateUserId;

}