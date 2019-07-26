package com.roger.ims;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.roger.ims.dao.SysRightDao;
import com.roger.ims.dao.SysRoleDao;
import com.roger.ims.dao.SysUserDao;
import com.roger.ims.dto.MenuVo;
import com.roger.ims.entity.SysRole;
import com.roger.ims.entity.SysUser;
import com.roger.ims.utils.GetMenuTree;
import com.roger.ims.utils.MapperUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsApplicationTests {
	@Autowired
	private SysRightDao sysRightDao;
	
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private SysUserDao sysUserDao;
	
	MapperUtil mapperUtil = new MapperUtil();

	@Test
	public void contextLoads() {
		List<MenuVo> menuList = mapperUtil.map(sysRightDao.findRightByUserId("131212"), MenuVo.class);
		GetMenuTree menuTree = new GetMenuTree();
		List<MenuVo> ret = menuTree.getMenuTree(menuList);
		System.out.println(ret);

	}
	@Ignore
	public void getUserInfoByUser() {
		SysUser user = new SysUser();
		user.setLoginName("131212");
		user.setPassword("1");
		SysUser retUser = sysUserDao.selectUserInfoByUser(user);
		System.out.println(retUser.getUsername());
	}
	
	@Ignore
	@Transactional
	public void tranTest() throws Exception{
		SysRole role = new SysRole();
		role.setRoleId(47L);
		role.setRoleName("first111");
		try {
			sysRoleDao.update(role);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Ignore
	public void addUser() {
		SysUser sysUser = new SysUser();
		sysUserDao.update(sysUser);
	}

}
