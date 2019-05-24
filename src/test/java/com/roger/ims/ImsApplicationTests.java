package com.roger.ims;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roger.ims.dto.Menu;
import com.roger.ims.mapper.SysRightMapper;
import com.roger.ims.utils.GetMenuTree;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsApplicationTests {
	@Autowired
	private SysRightMapper srm;

	@Test
	public void contextLoads() {
		List<Menu> menuList = srm.getRightByUserId("131212");
		GetMenuTree menuTree = new GetMenuTree();
		List<Menu> ret = menuTree.getMenuTree(menuList);
		System.out.println(ret);

	}

}
