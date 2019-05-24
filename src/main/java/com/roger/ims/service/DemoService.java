package com.roger.ims.service;


import java.util.List;

import com.roger.ims.entity.SysUser;

public interface DemoService {
	
	/* demo测试 */
	public SysUser demo(String loginName,String psaaword);

	public List<SysUser> selectAll();
}
