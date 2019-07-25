package com.roger.ims.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo {	
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
