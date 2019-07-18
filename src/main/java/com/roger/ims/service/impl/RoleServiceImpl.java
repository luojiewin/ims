package com.roger.ims.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roger.ims.entity.SysRole;
import com.roger.ims.mapper.SysRoleMapper;
import com.roger.ims.service.RoleService;
import com.roger.ims.vo.RoleVo;

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
	
	/**  
	 * @Title: selectRole 
	 * @Description: 查询角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#selectRole(com.roger.ims.vo.RoleVo)  
	 */
	@Override
	public List<RoleVo> selectRole(RoleVo role) {
		return srm.selectRole(role);
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
	
	/**  
	 * @Title: updateRole 
	 * @Description: 更新角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#updateRole(com.roger.ims.entity.SysRole)  
	 */
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
    
	
	/**  
	 * @Title: deleteRole 
	 * @Description: 删除角色
	 * @param role
	 * @return  
	 * @see com.roger.ims.service.RoleService#deleteRole(java.util.List)  
	 */
	@Override
	@Transactional
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
