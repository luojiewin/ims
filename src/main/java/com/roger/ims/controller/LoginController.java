package com.roger.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roger.ims.dto.Menu;
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
}
