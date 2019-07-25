package com.roger.ims.dao;

import com.roger.ims.dto.UserVo;
import com.roger.ims.entity.SysUser;

import java.util.List;

/**  
* @Title: SysUserMapper  
* @Description: 
* @author roger  
* @date 2019年7月18日  
*/  
public interface SysUserMapper extends BaseMapper<SysUser>{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_user
	 *
	 * @mbg.generated
	 */
	int insert(SysUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_user
	 *
	 * @mbg.generated
	 */
	List<SysUser> selectAll();


	/**  
	 * @Title: selectUserInfoByUser
	 * @Description: 根据登录账户查询
	 * @param user
	 * @return  SysUser
	 */  
	SysUser selectUserInfoByUser(SysUser user);
    
	
	/**  
	 * @Title: selectUser
	 * @Description: 用户列表查询
	 * @param user
	 * @return  
	 */  
	List<SysUser> selectUser(UserVo user);
	
	/**  
	 * @Title: updateUser
	 * @Description: 用户信息更新
	 * @param user
	 * @return  
	 */  
	int updateUser(SysUser user);
	
	/**  
	 * @Title: deleteUser
	 * @Description: 用户批量删除
	 * @param user
	 * @return  
	 */  
	int deleteUser(List<SysUser> user);
	
	

}