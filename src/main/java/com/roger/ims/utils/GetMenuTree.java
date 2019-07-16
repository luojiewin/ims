package com.roger.ims.utils;

import java.util.ArrayList;
import java.util.List;

import com.roger.ims.dto.Menu;

public class GetMenuTree {
	
	public List<Menu> getMenuTree(List<Menu> menuList) {
		List<Menu> menuTree = new ArrayList<Menu>();
		//判断是否为最外层节点，如果是，递归获取子节点
		for(Menu menu : menuList) {
			if(menu.getParentRight()==0) {
				getChildrenMenu(menuList,menu);
				menuTree.add(menu);
			}
		}
		return menuTree;
	}
	
	//如果存在子节点，添加子节点
	public void getChildrenMenu(List<Menu> menuList,Menu parentMenu) {
		for(Menu menu : menuList) {
			if(parentMenu.getRightId().equals(menu.getParentRight())) {
				parentMenu.getSubs().add(menu);
				getChildrenMenu(menuList,menu);
			}
		}
	}

}
