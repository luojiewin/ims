package com.roger.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roger.ims.dto.Role;
import com.roger.ims.entity.SysRole;
import com.roger.ims.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 角色界面
 */
@Controller
@Api(tags = "角色操作")
@RequestMapping("admin")
public class RoleController {
	@Autowired
	private RoleService rs;

	/**
	 * 分返回角色信息
	 * 
	 * @param request
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
		Role role = new Role();
		role.setRoleName(roleName);
		role.setDescription(description);
		// 查询数据
		List<Role> roleList = rs.selectRole(role);
		// 创建分页对象
		PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
		// 查询分页数
		Long total = pageInfo.getTotal();

		// 创建返回Map
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		resultMap.put("total", total);
		resultMap.put("data", roleList);

		return resultMap;
	}

	/**
	 * 添加权限
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "roles", method = RequestMethod.POST)
	@ResponseBody
	public String postRoles(@RequestBody SysRole role) {
		role.setCreationUserId(1L);
		role.setLastUpdateUserId(1L);
		int count = rs.insertRole(role);
		return count + "  success!!";
	}

	/**
	 * 更新角色信息
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "roles", method = RequestMethod.PUT)
	@ResponseBody
	public String putRole(@RequestBody SysRole role) {
		role.setLastUpdateUserId(2L);
		int count = rs.updateRole(role);
		return count + "  success!!";
	}

	/**
	 * 批量删除角色信息
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "roles", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRoles(@RequestBody List<SysRole> role) {
		int count = rs.deleteRole(role);
		return count + "  success!!";
	}

}
