package com.roger.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.dto.Role;
import com.roger.ims.entity.SysRole;
import com.roger.ims.mapper.SysRoleMapper;
import com.roger.ims.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private SysRoleMapper srm;
	
	@Override
	public List<Role> selectRole(Role role) {
		return srm.selectRole(role);
	}

	@Override
	public int insertRole(SysRole role) {
		return srm.insert(role);
	}

	@Override
	public int updateRole(SysRole role) {		
		return srm.updateRole(role);
	}

	@Override
	public int deleteRole(List<SysRole> role) {	
		return srm.deleteRole(role);
	}

}
