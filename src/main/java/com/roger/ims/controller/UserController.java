/**  
* @Title: UserController.java
* @Description:  
* @author roger  
* @date 2019年7月18日  
* @version 1.0  
*/ 
package com.roger.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roger.ims.dto.UserVo;
import com.roger.ims.entity.SysUser;
import com.roger.ims.service.UserService;

import io.swagger.annotations.Api;

/**  
* @Title: UserController  
* @Description: 用户界面controller
* @author roger  
* @date 2019年7月18日  
*/
@Controller
@RequestMapping("admin")
@Api("用户信息操作")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**  
	 * @Title: getUsers
	 * @Description: 获取用户列表
	 * @param userVo
	 * @return  
	 */  
	@RequestMapping(value="users",method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser> getUsers(@RequestParam long userId,String loginName,String username,String telphone ) {
		List<SysUser> sysUserList = new ArrayList<SysUser>();
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setLoginName(loginName);
		userVo.setUsername(username);
		userVo.setTelphone(telphone);
		
		sysUserList = userService.selectUser(userVo);
		return sysUserList;
	}
}
