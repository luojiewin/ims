package com.roger.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRight;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;
import com.roger.ims.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="user")
@Api(tags = "用户登录")
public class LoginController {

	@Autowired
	private LoginService ls;

	/**
	 * 获取权限列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "menus", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户菜单信息")
	public List<Menu> getMenu(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SysUser user = new SysUser();
		user = (SysUser) session.getAttribute("user");
		return ls.getMenuTree(user);
	}

	/**
	 * 用户登录
	 * @ApiOperation 用户登录信息验证
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ApiOperation(value = "用户登录信息验证")
	@ResponseBody
	public Map<Object, Object> UserLogin(@RequestBody SysUser user, HttpServletRequest request) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		SysUser retUser = ls.getUserInfoByUser(user);
		List<SysRole> retRole = ls.getRoleInfoByUser(retUser);
		List<SysRight> retRight = ls.getRightInfoByRole(retRole);
		if (retUser == null || "".equals(retUser)) {
			map.put("status", 201);
			return map;
		} else {
			map.put("userInfo", retUser);
			map.put("status", 200);
			createSession(retUser, retRole, retRight, request);
			return map;
		}
	}

	/**
	 * 创建用户session
	 */
	public void createSession(SysUser user, List<SysRole> role, List<SysRight> right, HttpServletRequest request) {
		// 使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("role", role);
		session.setAttribute("right", right);
	}
}
