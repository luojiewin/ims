package com.roger.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roger.ims.dto.MenuVo;
import com.roger.ims.dto.RightVo;
import com.roger.ims.dto.RoleVo;
import com.roger.ims.dto.UserVo;
import com.roger.ims.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Title: LoginController
 * @Description: 登陆界面controller类
 * @author roger
 * @date 2019年7月17日
 */

@Controller
@RequestMapping(value = "user")
@Api(tags = "用户登录")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * @Title: getMenu
	 * @Description: 获取用户菜单信息
	 * @param request
	 * @return
	 */
	@GetMapping(value = "menus")
	@ResponseBody
	@ApiOperation(value = "获取用户菜单信息")
	public List<MenuVo> getMenu(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		UserVo user = (UserVo) session.getAttribute("user");
		return loginService.findMenuTree(user);

	}

	/**
	 * @Title: userLogin
	 * @Description: 用戶登陸
	 * @param user
	 * @param request
	 * @return map
	 */
	@PostMapping(value = "login")
	@ApiOperation(value = "用户登录信息验证")
	@ResponseBody
	public Map<Object, Object> userLogin(@RequestBody UserVo user, HttpServletRequest request) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		UserVo retUser = loginService.findUserInfoByUser(user);
		List<RoleVo> retRole = loginService.findRoleInfoByUser(retUser);
		List<RightVo> retRight = loginService.findRightInfoByRole(retRole);
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
	 * @Title: createSession
	 * @Description: 创建用户sesion
	 * @param user
	 * @param role
	 * @param right
	 * @param request
	 */
	public void createSession(UserVo user, List<RoleVo> role, List<RightVo> right, HttpServletRequest request) {
		// 使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("role", role);
		session.setAttribute("right", right);
	}
}
