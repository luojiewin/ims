package com.roger.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;
import com.roger.ims.mapper.SysRightMapper;
import com.roger.ims.mapper.SysRoleMapper;
import com.roger.ims.mapper.SysUserMapper;
import com.roger.ims.service.LoginService;
import com.roger.ims.utils.GetMenuTree;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private SysRightMapper srm;
	@Autowired 
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserMapper sum;
	
	/**
	 * 获取菜单树
	 */
	@Override
	public List<Menu> getMenuTree(SysUser user) {
		List<Menu> menuList = srm.getRightByUserId(user.getLoginName());
		GetMenuTree menuTree = new GetMenuTree();
		return menuTree.getMenuTree(menuList);			
	}

	@Override
	public SysUser getUserInfoByUser(SysUser user) {
		return  sum.getUserInfoByUser(user);
	}

	@Override
	public List<SysRole> getRoleInfoByUser(SysUser user) {
		return sysRoleMapper.getRolesByUser(user);
	}

	@Override
	public List<SysRight> getRightInfoByRole(List<SysRole> roleList) {
		return srm.getRightsByRoles(roleList);
	}

}
