package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysUser;

public interface LoginService {
	
	/**
	 * 获取导航菜单树
	 * @return
	 */
	public List<Menu> getMenuTree();
	
	/**
	 * 获取用户信息
	 * @param user
	 * @return
	 */
	public SysUser getUserInfoByUser(SysUser user);
}
