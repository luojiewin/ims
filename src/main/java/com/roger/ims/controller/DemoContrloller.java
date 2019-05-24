package com.roger.ims.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roger.ims.entity.SysUser;
import com.roger.ims.service.DemoService;

@Controller
public class DemoContrloller {
	@Autowired
	private DemoService ds;
	
	@RequestMapping(value="/demo",method = RequestMethod.POST)
	@ResponseBody
	public int  demo(HttpServletRequest request) {
		String loginName =  request.getParameter("loginName");
		String password =  request.getParameter("password");
		if(ds.demo(loginName,password)==null) {
			return 0;
		}else {
			return 1;
		}
	}
	
	@RequestMapping(value="/selectAll",method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser>  demo2() {
		return ds.selectAll();
	}
}
