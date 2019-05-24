package com.roger.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roger.ims.dto.Role;
import com.roger.ims.entity.SysRole;
import com.roger.ims.service.RoleService;

/**
 * 角色界面
 */
@Controller
public class RoleController {
	@Autowired
	private RoleService rs;

	/**
	 * 分返回角色信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "selectRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> selectAllRole(HttpServletRequest request) {
		// 获取参数
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String roleName = request.getParameter("roleName");
		String description = request.getParameter("description");
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
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "addRole", method = RequestMethod.POST)
	@ResponseBody
	public String addRole(SysRole role) {
		role.setCreationUserId(1L);
		role.setLastUpdateUserId(1L);
		int count = rs.insertRole(role);
		return count+"  success!!";
	}
	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "updateRole", method = RequestMethod.POST)
	@ResponseBody
	public String updateRole(SysRole role) {
		role.setLastUpdateUserId(2L);
		int count = rs.updateRole(role);
		return count+"  success!!";
	}
	
	/**
	 * 批量删除角色信息
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public String deleteRole(@RequestBody List<SysRole> role) {
		System.out.println("111");
		int count = rs.deleteRole(role);
		return count+"  success!!";
	}
	
	
}
