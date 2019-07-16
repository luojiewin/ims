package com.roger.ims.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.roger.ims.dto.Role;
import com.roger.ims.entity.SysRole;
import com.roger.ims.mapper.SysRoleMapper;
import com.roger.ims.service.RoleService;
import ch.qos.logback.classic.Logger;

@Service
public class RoleServiceImpl implements RoleService{
	
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private SysRoleMapper srm;
	
	@Override
	public List<Role> selectRole(Role role) {
		return srm.selectRole(role);
	}

	@Override
	@Transactional
	public int insertRole(SysRole role) {
		int result = -1;
		try {
			 result =  srm.insert(role);
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return result;
	}

	@Override
	@Transactional
	public int updateRole(SysRole role) {	
		int result = 0;
		try {
			result = srm.updateRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteRole(List<SysRole> role) {	
		int result = 0;
		try {
			result = srm.deleteRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
