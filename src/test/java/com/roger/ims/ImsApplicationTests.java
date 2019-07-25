package com.roger.ims;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.roger.ims.dao.SysRightMapper;
import com.roger.ims.dao.SysRoleMapper;
import com.roger.ims.dao.SysUserMapper;
import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;
import com.roger.ims.utils.GetMenuTree;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsApplicationTests {
	@Autowired
	private SysRightMapper srm;
	
	@Autowired
	private SysRoleMapper srm1;
	
	@Autowired
	private SysUserMapper sum;

	@Ignore
	public void contextLoads() {
		List<Menu> menuList = srm.selectRightByUserId("131212");
		GetMenuTree menuTree = new GetMenuTree();
		List<Menu> ret = menuTree.getMenuTree(menuList);
		System.out.println(ret);

	}
	@Ignore
	public void getUserInfoByUser() {
		SysUser user = new SysUser();
		user.setLoginName("131212");
		user.setPassword("1");
		SysUser retUser = sum.selectUserInfoByUser(user);
		System.out.println(retUser.getUsername());
	}
	
	@Ignore
	@Transactional
	public void tranTest() throws Exception{
		SysRole role = new SysRole();
		role.setRoleId(47L);
		role.setRoleName("first111");
		try {
			srm1.updateRole(role);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void addUser() {
		SysUser sysUser = new SysUser();
		sum.update(sysUser);
	}

}
