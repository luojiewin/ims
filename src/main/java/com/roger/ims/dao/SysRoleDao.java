package com.roger.ims.dao;

import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;

import java.util.List;

public interface SysRoleDao extends BaseDao<SysRole>{

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
	List<SysRole> findRolesByUser(SysUser user);
}