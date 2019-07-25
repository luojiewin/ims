package com.roger.ims.service.impl;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roger.ims.dao.SysRoleMapper;
import com.roger.ims.dto.RoleVo;
import com.roger.ims.entity.SysRole;
import com.roger.ims.service.RoleService;
import com.roger.ims.utils.MapperUtil;
import ch.qos.logback.classic.Logger;

/**  
* @Title: RoleServiceImpl  
* @Description: 角色管理service实现类
* @author roger  
* @date 2019年7月17日  
*/  
@Service
public class RoleServiceImpl implements RoleService{
	
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private SysRoleMapper srm;
	
	MapperUtil mapperUtil = new MapperUtil();
	
	/**  
	 * @Title: selectRole 
	 * @Description: 查询角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#selectRole(com.roger.ims.dto.RoleVo)  
	 */
	@Override
	public List<RoleVo> selectRole(RoleVo role) {
		SysRole  sysRole = new SysRole();
		mapperUtil.map(role, SysRole.class);
		return mapperUtil.map(srm.findAll(sysRole), RoleVo.class);
	}

	/** 
	 * @Title: insertRole 
	 * @Description: 添加角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#insertRole(com.roger.ims.entity.SysRole)  
	 */
	@Override
	@Transactional
	public int insertRole(RoleVo role) {
		SysRole sysRole = mapperUtil.map(role, SysRole.class);
		int result = -1;
		try {
			 result =  srm.add(sysRole);
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return result;
	}
	
	/**  
	 * @Title: updateRole 
	 * @Description: 更新角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#updateRole(com.roger.ims.entity.SysRole)  
	 */
	@Override
	@Transactional
	public int updateRole(RoleVo role) {	
		SysRole sysRole = mapperUtil.map(role, SysRole.class);
		int result = 0;
		try {
			result = srm.updateRole(sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    
	
	/**  
	 * @Title: deleteRole 
	 * @Description: 删除角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#deleteRole(java.util.List)  
	 */
	@Override
	@Transactional
	public int deleteRole(List<RoleVo> role) {	
		List<SysRole> roleVoList = mapperUtil.map(role, SysRole.class);
		int result = 0;
		try {
			result = srm.deleteRole(roleVoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
