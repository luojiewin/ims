package com.roger.ims.dao;

import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole>{

	/**  
	 * @Title: updateRole
	 * @Description: 更新角色信息
	 * @param role
	 * @return  
	 */  
	int updateRole(SysRole role);


	/**  
	 * @Title: deleteRole
	 * @Description: 批量删除角色信息
	 * @param role
	 * @return  
	 */  
	int deleteRole(List<SysRole> role);
	
	/**  
	 * @Title: selectRolesByUser
	 * @Description: 根据用户获取权限
	 * @param user
	 * @return  
	 */  
	List<SysRole> selectRolesByUser(SysUser user);
}