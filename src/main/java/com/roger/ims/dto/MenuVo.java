package com.roger.ims.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
* @Title: Menu  
* @Description:菜单列表 
* @author roger  
* @date 2019年7月26日  
*/  
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo {
	@JsonIgnore
	private Long rightId;
	
	private String title;
	
	/** 权限名称 */
	@JsonIgnore
	private String rightName;
	
	@JsonIgnore
    private Long parentRight;
	
    private String index;
    
    @JsonInclude(Include.NON_EMPTY)
    private String icon;
    
    @JsonInclude(Include.NON_EMPTY)
    private List<MenuVo> subs = new ArrayList<MenuVo>();
    
}
