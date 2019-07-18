package com.roger.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roger.ims.entity.SysRole;
import com.roger.ims.service.RoleService;
import com.roger.ims.vo.RoleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**  
* @Title: RoleController  
* @Description: 角色管理界面
* @author roger  
* @date 2019年7月17日  
*/  
@Controller
@Api(tags = "角色操作")
@RequestMapping("admin")
public class RoleController {
	
	@Autowired
	private RoleService rs;

	
	/**  
	 * @Title: getRoles
	 * @Description: 获取权限
	 * @param pageNum
	 * @param pageSize
	 * @param roleName
	 * @param description
	 * @return  
	 */  
	@RequestMapping(value = "roles", method = RequestMethod.GET)
	@ApiOperation(value= "获取角色列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum",required = true,value = "页数"),
		@ApiImplicitParam(name = "pageSize",required = true,value = "每页显示数量"),
		@ApiImplicitParam(name = "roleName",value = "角色名称"),
		@ApiImplicitParam(name = "description",value = "角色描述")
	})
	@ResponseBody
	public Map<Object, Object> getRoles(@RequestParam String pageNum, String pageSize, String roleName,
			String description) {
		// 创建分页
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
		RoleVo role = new RoleVo();
		role.setRoleName(roleName);
		role.setDescription(description);
		// 查询数据
		List<RoleVo> roleList = rs.selectRole(role);
		// 创建分页对象
		PageInfo<RoleVo> pageInfo = new PageInfo<RoleVo>(roleList);
		// 查询分页数
		Long total = pageInfo.getTotal();

		// 创建返回Map
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		resultMap.put("total", total);
		resultMap.put("data", roleList);

		return resultMap;
	}

	
	/**  
	 * @Title: postRoles
	 * @Description: 添加角色 
	 * @param role
	 * @return  
	 */  
	@RequestMapping(value = "roles", method = RequestMethod.POST)
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	@ApiOperation(value= "添加角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "role",required = true,value = "角色信息",dataType = "SysRole")
	})
	public String postRoles(@RequestBody SysRole role) {
		role.setCreationUserId(1L);
		role.setLastUpdateUserId(1L);
		int count = rs.insertRole(role);
		return count + "  success!!";
	}

	
	/**  
	 * @Title: putRole
	 * @Description: 更新角色
	 * @param role
	 * @return  
	 */  
	@RequestMapping(value = "roles", method = RequestMethod.PUT)
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	@ApiOperation(value= "更新角色信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "role",required = true,value = "角色信息",dataType = "SysRole")
	})
	public String putRole(@RequestBody SysRole role) {
		role.setLastUpdateUserId(2L);
		int count = rs.updateRole(role);
		return count + "  success!!";
	}

	
	/**  
	 * @Title: deleteRoles
	 * @Description: 批量删除角色
	 * @param role
	 * @return  
	 */  
	@RequestMapping(value = "roles", method = RequestMethod.DELETE)
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	@ApiOperation(value= "删除角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "role",required = true,value = "角色信息列表")
	})
	public String deleteRoles(@RequestBody List<SysRole> role) {
		int count = rs.deleteRole(role);
		return count + "  success!!";
	}

}
