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
import com.roger.ims.entity.SysUser;
import com.roger.ims.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService ls;
	
	/**
	 * 获取权限列表
	 * @return
	 */
	@RequestMapping(value ="/getMenu",method=RequestMethod.POST)
	@ResponseBody
	public List<Menu> getMenu() {
		return ls.getMenuTree();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value ="/userLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> UserLogin(@RequestBody SysUser user,HttpServletRequest request){
		Map<Object,Object> map = new HashMap<Object, Object>();
		System.out.println(user.getLoginName());
		SysUser retUser = ls.getUserInfoByUser(user);
		if(retUser == null || "".equals(retUser)){
			map.put("status", 201);
			return map;
		}else {
			map.put("userInfo", retUser);
			map.put("status", 200);
			createSession(retUser,request);
			return map;
		}
	}
	
	
	/**
	 * 创建用户session
	 */
    public void createSession(SysUser user,HttpServletRequest request) {
    	//使用request对象的getSession()获取session，如果session不存在则创建一个
    	HttpSession session = request.getSession();
    	session.setAttribute("userId", user.getUserId());
    }
}
