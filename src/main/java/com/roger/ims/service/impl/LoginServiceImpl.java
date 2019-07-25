package com.roger.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.dao.SysRightMapper;
import com.roger.ims.dao.SysRoleMapper;
import com.roger.ims.dao.SysUserMapper;
import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;
import com.roger.ims.service.LoginService;
import com.roger.ims.utils.GetMenuTree;

/**  
* @Title: LoginServiceImpl  
* @Description: 登录界面service实现类
* @author roger  
* @date 2019年7月17日  
*/  
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private SysRightMapper sysRightMapper;
	@Autowired 
	private SysRoleMapper sysRoleMapper;	
	@Autowired
	private SysUserMapper sum;
	
	
	/**  
	 * @Title: getMenuTree 
	 * @Description: 获取菜单树
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.LoginService#getMenuTree(com.roger.ims.entity.SysUser)  
	 */
	@Override
	public List<Menu> getMenuTree(SysUser user) {
		List<Menu> menuList = sysRightMapper.selectRightByUserId(user.getLoginName());
		GetMenuTree menuTree = new GetMenuTree();
		return menuTree.getMenuTree(menuList);		
	}
	
	
	/**  
	 * @Title: selectUserInfoByUser 
	 * @Description: 根据用户账户获取用户信息
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.LoginService#getUserInfoByUser(com.roger.ims.entity.SysUser)  
	 */
	@Override
	public SysUser selectUserInfoByUser(SysUser user) {
		return  sum.selectUserInfoByUser(user);
	}

	/**  
	 * @Title: selectRoleInfoByUser 
	 * @Description: 根据用户信息获取角色信息
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.LoginService#getRoleInfoByUser(com.roger.ims.entity.SysUser)  
	 */
	@Override
	public List<SysRole> selectRoleInfoByUser(SysUser user) {
		return sysRoleMapper.selectRolesByUser(user);
	}

	
	/**  
	 * @Title: selectRightInfoByRole 
	 * @Description: 根据角色获取权限信息
	 * @param roleList
	 * @return  
	 * @see com.roger.ims.service.LoginService#getRightInfoByRole(java.util.List)  
	 */
	@Override
	public List<SysRight> selectRightInfoByRole(List<SysRole> roleList) {
		return sysRightMapper.selectRightsByRoles(roleList);
	}

}
