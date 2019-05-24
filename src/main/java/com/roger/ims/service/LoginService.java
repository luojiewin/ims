package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.Menu;

public interface LoginService {
	
	/**
	 * 获取导航菜单树
	 */
	public List<Menu> getMenuTree();
}
