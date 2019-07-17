package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;


/**  
* @Title: LoginService  
* @Description: 登录界面service
* @author roger  
* @date 2019年7月17日  
*/  
public interface LoginService {
	
	/**  
	 * @Title: getMenuTree
	 * @Description: 获取导航菜单树
	 * @param user
	 * @return  
	 */  
	public List<Menu> getMenuTree(SysUser user);
	
	/**  
	 * @Title: getUserInfoByUser
	 * @Description: 获取用户信息
	 * @param user
	 * @return  
	 */  
	public SysUser getUserInfoByUser(SysUser user);
	

	/**  
	 * @Title: getRoleInfoByUser
	 * @Description: 获取角色信息
	 * @param user
	 * @return  
	 */  
	public List<SysRole> getRoleInfoByUser(SysUser user);

	/**  
	 * @Title: getRightInfoByRole
	 * @Description: 根据角色获取权限信息
	 * @param roleList
	 * @return  
	 */  
	public List<SysRight> getRightInfoByRole(List<SysRole> roleList);
}
