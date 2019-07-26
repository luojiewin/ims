package com.roger.ims.dao;

import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;
import java.util.List;

public interface SysRightDao extends BaseDao<SysRight>{ 
	
    /**  
     * @Title: findRightByUserId
     * @Description: 根据用户ID获取菜单权限
     * @param userId
     * @return  List<SysRight>
     */  
    List<SysRight> findRightByUserId(String userId);
    

    /**  
     * @Title: findRightsByRoles
     * @Description: 根据角色信息获取权限信息
     * @param rolelist
     * @return  List<SysRight>
     */  
    List<SysRight> findRightsByRoles(List<SysRole> rolelist);
}