/**  
* @Title: RightVo.java
* @Description:  
* @author roger  
* @date 2019年7月25日  
* @version 1.0  
*/
package com.roger.ims.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: RightVo
 * @Description:
 * @author roger
 * @date 2019年7月25日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightVo {

	/** 权限ID */
	private Long rightId;

	/** 权限名称 */
	private String rightName;

	/** 权限父节点*/  
	private Long parentRight;

	/** 权限登记*/  
	private Integer rightLevel;

	/** 菜单索引*/  
	private String menuIndex;

	/** 按钮*/  
	private String icon;

	/** 权限描述*/  
	private String description;

	/** creationTime*/  
	private Date creationTime;

	/** creationUserId*/  
	private Long creationUserId;

	/** lastUpdateTime*/  
	private Date lastUpdateTime;

	/** lastUpdateUserId*/  
	private Long lastUpdateUserId;
}
