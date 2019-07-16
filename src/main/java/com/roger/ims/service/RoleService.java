package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.Role;
import com.roger.ims.entity.SysRole;

public interface RoleService {
	/**
	 * 查询所有角色
	 */
	List<Role> selectRole(Role role);
	
	/**
	 * 插入角色信息
	 */
	int insertRole(SysRole role);
	
	/**
	 * 更新角色信息
	 */
	int updateRole(SysRole role);
	
	/**
	 * 批量删除角色
	 */
	int deleteRole(List<SysRole> role);
}
