/**  
* @Title: UserServiceImpl.java
* @Description:  
* @author roger  
* @date 2019年7月18日  
* @version 1.0  
*/ 
package com.roger.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.dao.SysUserMapper;
import com.roger.ims.dto.UserVo;
import com.roger.ims.entity.SysUser;
import com.roger.ims.service.UserService;

/**  
* @Title: UserServiceImpl  
* @Description: 用户界面UserService实现类
* @author roger  
* @date 2019年7月18日  
*/
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	/**  
	 * @Title: selectUser 
	 * @Description: 用户查询
	 * @param user
	 * @return  
	 * @see com.roger.ims.service.UserService#selectUser(com.roger.ims.dto.UserVo)  
	 */
	@Override
	public List<SysUser> selectUser(UserVo user) {
		return sysUserMapper.selectUser(user);
	}
	
}
