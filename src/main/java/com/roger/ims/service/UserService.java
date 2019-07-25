/**  
* @Title: UserService.java
* @Description:  
* @author roger  
* @date 2019年7月18日  
* @version 1.0  
*/ 
package com.roger.ims.service;

import java.util.List;

import com.roger.ims.dto.UserVo;
import com.roger.ims.entity.SysUser;

/**  
* @Title: UserService  
* @Description: 用户界面service接口类
* @author roger  
* @date 2019年7月18日  
*/
public interface UserService {
	
	/**  
	 * @Title: selectUser
	 * @Description: 用户查询
	 * @param user
	 * @return  
	 */  
	public List<SysUser> selectUser(UserVo user);
}
