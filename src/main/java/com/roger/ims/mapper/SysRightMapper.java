package com.roger.ims.mapper;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;

import java.util.List;

public interface SysRightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right
     *
     * @mbg.generated
     */
    int insert(SysRight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_right
     *
     * @mbg.generated
     */
    List<SysRight> selectAll();
    
	/**
	 * 根据用户ID获取菜单权限
	 * @param userId
	 * @return
	 */
    List<Menu> getRightByUserId(String userId);
    
    /**
     * 根据角色信息获取权限信息
     * @param rolelist
     * @return
     */
    List<SysRight> getRightsByRoles(List<SysRole> rolelist);
}