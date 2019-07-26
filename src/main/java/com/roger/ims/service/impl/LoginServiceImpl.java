package com.roger.ims.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.dao.SysRightDao;
import com.roger.ims.dao.SysRoleDao;
import com.roger.ims.dao.SysUserDao;
import com.roger.ims.dto.MenuVo;
import com.roger.ims.dto.RightVo;
import com.roger.ims.dto.RoleVo;
import com.roger.ims.dto.UserVo;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;
import com.roger.ims.service.LoginService;
import com.roger.ims.utils.GetMenuTree;
import com.roger.ims.utils.MapperUtil;

/**  
* @Title: LoginServiceImpl  
* @Description: 登录界面service实现类
* @author roger  
* @date 2019年7月17日  
*/  
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private SysRightDao sysRightMapper;
	@Autowired 
	private SysRoleDao sysRoleMapper;	
	@Autowired
	private SysUserDao sysUserDao;
	
	MapperUtil mapperUtil = new MapperUtil();

	/**  
	 * @Title: getMenuTree 
	 * @Description: 获取菜单树
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.LoginService#findMenuTree(com.roger.ims.dto.UserVo)  
	 */
	@Override
	public List<MenuVo> findMenuTree(UserVo user) {
		List<MenuVo> menuList = mapperUtil.map(sysRightMapper.findRightByUserId(user.getLoginName()), MenuVo.class);
		List<MenuVo> menuListTemp = new ArrayList<MenuVo>();
		//menuVO中rightName为接收do数据，转成tittle用于页面显示
		for(MenuVo menuVo:menuList) {
			menuVo.setTitle(menuVo.getRightName());
			menuListTemp.add(menuVo);
		}
		GetMenuTree menuTree = new GetMenuTree();
		return menuTree.getMenuTree(menuListTemp);		
	}
	
	

	/**  
	 * @Title: selectUserInfoByUser 
	 * @Description: 根据用户账户获取用户信息
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.LoginService#findUserInfoByUser(com.roger.ims.dto.UserVo)  
	 */
	@Override
	public UserVo findUserInfoByUser(UserVo user) {
		SysUser sysUser = mapperUtil.map(user, SysUser.class);
		return  mapperUtil.map(sysUserDao.selectUserInfoByUser(sysUser),UserVo.class);
	}


	/**  
	 * @Title: selectRoleInfoByUser 
	 * @Description: 根据用户信息获取角色信息
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.LoginService#findRoleInfoByUser(com.roger.ims.dto.UserVo)  
	 */
	@Override
	public List<RoleVo> findRoleInfoByUser(UserVo user) {
		SysUser sysUser = mapperUtil.map(user,SysUser.class);
		return mapperUtil.map(sysRoleMapper.findRolesByUser(sysUser),RoleVo.class);
	}

	
	/**  
	 * @Title: selectRightInfoByRole 
	 * @Description: 根据角色获取权限信息
	 * @param roleList
	 * @return  
	 * @see com.roger.ims.service.LoginService#getRightInfoByRole(java.util.List)  
	 */
	@Override
	public List<RightVo> findRightInfoByRole(List<RoleVo> roleList) {
		List<SysRole> sysRoleList = mapperUtil.map(roleList, SysRole.class);
		return mapperUtil.map(sysRightMapper.findRightsByRoles(sysRoleList), RightVo.class);
	}

}
