package com.roger.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysUser;
import com.roger.ims.mapper.SysRightMapper;
import com.roger.ims.mapper.SysUserMapper;
import com.roger.ims.service.LoginService;
import com.roger.ims.utils.GetMenuTree;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private SysRightMapper srm;
	
	@Autowired
	private SysUserMapper sum;
	
	/**
	 * 获取菜单树
	 */
	@Override
	public List<Menu> getMenuTree() {
		List<Menu> menuList = srm.getRightByUserId("131212");
		GetMenuTree menuTree = new GetMenuTree();
		return menuTree.getMenuTree(menuList);			
	}

	@Override
	public SysUser getUserInfoByUser(SysUser user) {
		return  sum.getUserInfoByUser(user);
	}

}
