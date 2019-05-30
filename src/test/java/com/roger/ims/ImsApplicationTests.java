package com.roger.ims;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roger.ims.dto.Menu;
import com.roger.ims.entity.SysUser;
import com.roger.ims.mapper.SysRightMapper;
import com.roger.ims.mapper.SysUserMapper;
import com.roger.ims.utils.GetMenuTree;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsApplicationTests {
	@Autowired
	private SysRightMapper srm;
	
	@Autowired
	private SysUserMapper sum;

	@Ignore
	public void contextLoads() {
		List<Menu> menuList = srm.getRightByUserId("131212");
		GetMenuTree menuTree = new GetMenuTree();
		List<Menu> ret = menuTree.getMenuTree(menuList);
		System.out.println(ret);

	}
	@Test
	public void getUserInfoByUser() {
		SysUser user = new SysUser();
		user.setLoginName("131212");
		user.setPassword("1");
		SysUser retUser = sum.getUserInfoByUser(user);
		System.out.println(retUser.getUsername());
	}

}
