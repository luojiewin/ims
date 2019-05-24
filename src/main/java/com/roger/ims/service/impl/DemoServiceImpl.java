package com.roger.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.ims.entity.SysUser;
import com.roger.ims.mapper.SysUserMapper;
import com.roger.ims.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{
	@Autowired
	private SysUserMapper sum;
	
	public SysUser demo(String loginName,String psaaword){
		return sum.selectByLoginName(loginName, psaaword);
	}

	@Override
	public List<SysUser> selectAll() {
		return sum.selectAll();
	}
}
