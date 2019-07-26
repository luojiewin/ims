package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.MenuVo;
import com.roger.ims.dto.RightVo;
import com.roger.ims.dto.RoleVo;
import com.roger.ims.dto.UserVo;


/**  
* @Title: LoginService  
* @Description: 登录界面service
* @author roger  
* @date 2019年7月17日  
*/  
public interface LoginService {
	
	/**  
	 * @Title: findMenuTree
	 * @Description: 获取导航菜单树
	 * @param user
	 * @return  
	 */  
	public List<MenuVo> findMenuTree(UserVo user);
	
	/**  
	 * @Title: findUserInfoByUser
	 * @Description: 获取用户信息
	 * @param user
	 * @return  
	 */  
	public UserVo findUserInfoByUser(UserVo user);
	

	/**  
	 * @Title: findRoleInfoByUser
	 * @Description: 获取角色信息
	 * @param user
	 * @return  
	 */  
	public List<RoleVo> findRoleInfoByUser(UserVo user);

	/**  
	 * @Title: findRightInfoByRole
	 * @Description: 根据角色获取权限信息
	 * @param roleList
	 * @return  
	 */  
	public List<RightVo> findRightInfoByRole(List<RoleVo> roleList);
}
