package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;

public interface LoginService {
	
	/**
	 * 获取导航菜单树
	 * @return
	 */
	public List<Menu> getMenuTree(SysUser user);
	
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	public SysUser getUserInfoByUser(SysUser user);
	
	/**
	 * 获取角色信息
	 * @param user
	 * @return
	 */
	
	public List<SysRole> getRoleInfoByUser(SysUser user);

	/**
	 * 根据角色获取权限信息
	 * @param roleList
	 * @return
	 */
	public List<SysRight> getRightInfoByRole(List<SysRole> roleList);
}
