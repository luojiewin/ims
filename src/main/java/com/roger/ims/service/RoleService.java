package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.RoleVo;

/**  
* @Title: RoleService  
* @Description: 角色管理service接口类
* @author roger  
* @date 2019年7月17日  
*/  
public interface RoleService {

	/**  
	 * @Title: selectRole
	 * @Description: 查询所有角色
	 * @param role
	 * @return  
	 */  
	List<RoleVo> findAllRole(RoleVo role);
	
	/**  
	 * @Title: insertRole
	 * @Description: 插入角色信息
	 * @param role
	 * @return  
	 */  
	int addRole(RoleVo role);
	
	/**  
	 * @Title: updateRole
	 * @Description: 更新角色信息
	 * @param role
	 * @return  
	 */  
	int updateRole(RoleVo role);
	
	/**  
	 * @Title: deleteRole
	 * @Description: 批量删除角色
	 * @param role
	 * @return  
	 */  
	int deleteRole(List<RoleVo> role);
}
